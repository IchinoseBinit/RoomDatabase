package com.example.roomapplication.view.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomapplication.R;


public class UserViewHolder extends RecyclerView.ViewHolder {

    public TextView txtViewName;
    public TextView txtViewAge;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        txtViewName = itemView.findViewById(R.id.textViewName);
        txtViewAge = itemView.findViewById(R.id.textViewAge);
    }
}
