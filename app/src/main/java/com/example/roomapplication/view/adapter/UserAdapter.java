package com.example.roomapplication.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomapplication.R;
import com.example.roomapplication.model.user.User;
import com.example.roomapplication.view.viewholder.*;


import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    ArrayList<User> users;

    public UserAdapter(ArrayList users) {
        this.users = users;
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);

        holder.txtViewName.setText(user.getName());
        holder.txtViewAge.setText("ID: " + user.getId() );
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
