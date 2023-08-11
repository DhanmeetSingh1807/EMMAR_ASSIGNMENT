package com.example.emmar_assignment.ui.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.emmar_assignment.ui.dao.UserDao;
import com.example.emmar_assignment.ui.entity.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME="AppDatabase";

    public abstract UserDao userDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context){
        if(INSTANCE == null)
        {
            synchronized (AppDatabase.class){
                if(INSTANCE == null)
                {
                    INSTANCE= Room.databaseBuilder(context,AppDatabase.class, DATABASE_NAME).build();
                }
            }
        }
        return INSTANCE;
    }
}