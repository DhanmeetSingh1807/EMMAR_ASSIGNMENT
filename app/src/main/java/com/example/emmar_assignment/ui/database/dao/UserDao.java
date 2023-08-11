package com.example.emmar_assignment.ui.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.emmar_assignment.ui.database.entity.User;
import java.util.List;
/**
 * Created by Dhanmeet on 11/08/23.
 */
@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<User> user);

    @Query("SELECT * FROM User")
    LiveData<List<User>> getAllUsers();
}