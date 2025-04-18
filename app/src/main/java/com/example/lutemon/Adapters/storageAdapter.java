package com.example.lutemon.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemon.R;
import com.example.lutemon.mons.Lutemon;

import java.util.List;

public class storageAdapter extends RecyclerView.Adapter<storageAdapter.ViewHolder> {
    private List<Lutemon> lutemons;
    private Context context;

    public storageAdapter(List<Lutemon> lutemons,Context context){
        this.lutemons = lutemons;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lutemons,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(position);

        holder.monname.setText(lutemon.getName());
        holder.color.setText(lutemon.getColor());
        holder.detail.setText(lutemon.getDetails());
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateItems(List<Lutemon> newLutemons){
        lutemons.clear();
        lutemons.addAll(newLutemons);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView monname,color,detail;
        CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            monname = itemView.findViewById(R.id.name);
            color = itemView.findViewById(R.id.color);
            detail = itemView.findViewById(R.id.details);
            checkBox = itemView.findViewById(R.id.checkbox);
        }
    }
}
