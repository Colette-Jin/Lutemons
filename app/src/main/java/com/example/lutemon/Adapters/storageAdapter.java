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
    /**
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lutemons,parent,false);
        return new ViewHolder(view);
    }

    /**
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(position);

        //bind data to views
        holder.monname.setText(lutemon.getName());
        holder.color.setText(lutemon.getColor());
        holder.detail.setText(lutemon.getDetails());
    }

    /**
     * @return
     */
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
