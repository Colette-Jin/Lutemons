package com.example.lutemon.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemon.R;
import com.example.lutemon.mons.Lutemon;
import java.util.List;

public class LutemonAdapter extends RecyclerView.Adapter<LutemonAdapter.ViewHolder> {

    private List<Lutemon> lutemons;

    public LutemonAdapter(List<Lutemon> lutemons) {
        this.lutemons = lutemons;
    }

    public void updateList(List<Lutemon> newList) {
        this.lutemons = newList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameText;
        public TextView colorText;
        public TextView details;

        public ViewHolder(View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.name);
            colorText = itemView.findViewById(R.id.color);
            details = itemView.findViewById(R.id.details);
        }
    }

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
        holder.details.setText("Attack: "+lutemon.getAttack()+", Defense: "+lutemon.getDefence()+", XP: "+lutemon.getExperience());
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}

