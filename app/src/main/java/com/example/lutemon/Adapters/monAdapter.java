package com.example.lutemon.Adapters;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemon.R;

public class monAdapter extends RecyclerView.Adapter<> {


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTeamName, tvTeamLocation, tvTeamYear;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTeamName = itemView.findViewById(R.id.team_name);
            tvTeamLocation = itemView.findViewById(R.id.team_location);
            tvTeamYear = itemView.findViewById(R.id.team_year);
            Log.d("TeamAdapter", "ViewHolder constructor called");
        }
    }
}
