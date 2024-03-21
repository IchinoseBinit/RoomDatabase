package com.example.roomapplication.model.database;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomapplication.model.Person;
import com.example.roomapplication.model.user.User;
import com.example.roomapplication.model.user.UserDao;

@Database(entities = {User.class}, version = 1)
public abstract class MyAppDatabase extends RoomDatabase {

    private static volatile MyAppDatabase INSTANCE;

    public abstract UserDao userDao();

    public static synchronized MyAppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MyAppDatabase.class, "my_database")
                    .build();
        }
        return INSTANCE;
    }
}
