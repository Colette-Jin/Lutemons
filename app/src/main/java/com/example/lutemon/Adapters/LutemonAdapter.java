package com.example.lutemon.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemon.R;
import com.example.lutemon.mons.Lutemon;

import java.util.ArrayList;
import java.util.List;

public class LutemonAdapter extends RecyclerView.Adapter<LutemonAdapter.ViewHolder> {

    private List<Lutemon> lutemons;
    private List<Lutemon> selectedmons = new ArrayList<>();

    public LutemonAdapter(List<Lutemon> lutemons) {
        this.lutemons = lutemons;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameText;
        public TextView colorText;
        public TextView details;
        public CheckBox checkBox;
        public ImageView imageview;
        public ViewHolder(View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.imageView2);
            nameText = itemView.findViewById(R.id.name);
            colorText = itemView.findViewById(R.id.color);
            details = itemView.findViewById(R.id.details);
            checkBox = itemView.findViewById(R.id.checkbox);
        }
    }

    @NonNull
    @Override
    public LutemonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lutemons, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(position);
        holder.nameText.setText(lutemon.getName());
        holder.colorText.setText(lutemon.getColor());
        holder.details.setText(lutemon.getDetails());
        holder.imageview.setImageResource(lutemon.getImageID());

        //status of checkboxes, add lutemons checked to List selectedmons
        holder.checkBox.setOnClickListener(null);
        holder.checkBox.setChecked(selectedmons.contains(lutemon));
        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                if (!selectedmons.contains(lutemon)) {
                    selectedmons.add(lutemon);
                }
            } else {
                selectedmons.remove(lutemon);
            }
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateList(List<Lutemon> newList) {
        lutemons.clear();
        lutemons.addAll(newList);
        notifyDataSetChanged();
    }//update lutemons and values of their attributes

    @Override
    public int getItemCount() {
        return lutemons.size();
    }

    public List<Lutemon> getSelectedmons(){
        return selectedmons;
    }//get checked lutemons
}

