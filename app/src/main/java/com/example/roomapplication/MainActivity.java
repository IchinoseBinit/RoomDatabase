package com.example.roomapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roomapplication.model.user.User;
import com.example.roomapplication.model.database.MyAppDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private Button buttonInsert;

    private MyAppDatabase myAppDatabase;
    private Executor executor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextName = findViewById(R.id.editTextName);
        buttonInsert = findViewById(R.id.buttonInsert);
        Button buttonNavigate = findViewById(R.id.buttonNavigate);

        // Initialize database
        myAppDatabase = MyAppDatabase
                .getInstance(this);

        // Create a single-thread executor for database operations
        executor = Executors.newSingleThreadExecutor();


        // Set click listener for insert button
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = editTextName.getText().toString();
                Log.d("insert btn", "success");
                insertUser();
            }
        });

        buttonNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity((new Intent(MainActivity.this, RecyclerActivity.class)));
            }
        });
    }

    // Method to insert user into the database
    private void insertUser() {
        // Get user input from EditText
        String name = editTextName.getText().toString().trim();

        // Check if name is empty
        if (name.isEmpty()) {
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create User object
        User user = new User(name);
//      // Class obj = keyword constructor

//        myAppDatabase.userDao().insert(user);

//        // Execute database operation on background thread
        executor.execute(new Runnable() {
            @Override
            public void run() {
                myAppDatabase.userDao().insert(user);
            }
        });



        // Clear EditText after insertion
        editTextName.setText("");

        // Show success message
        Toast.makeText(this, "User inserted successfully", Toast.LENGTH_SHORT).show();


    }
}
