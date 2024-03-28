package com.example.roomapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomapplication.model.database.MyAppDatabase;
import com.example.roomapplication.model.user.User;
import com.example.roomapplication.view.adapter.UserAdapter;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RecyclerActivity extends AppCompatActivity {


    ArrayList<User> users= new ArrayList<User>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_activity);
        MyAppDatabase myAppDatabase = MyAppDatabase
                .getInstance(this);
        Executor executor = Executors.newSingleThreadExecutor();

        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);



        executor.execute(new Runnable() {
            @Override
            public void run() {
                users = (ArrayList<User>) myAppDatabase.userDao().getAllUsers();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setContentView(R.layout.recycler_activity);
                        RecyclerView recyclerView = findViewById(R.id.rvStudents);
                        UserAdapter adapter = new UserAdapter(users);
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        });
    }
}
