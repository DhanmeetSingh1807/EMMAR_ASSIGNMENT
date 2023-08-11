package com.example.emmar_assignment.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.emmar_assignment.ui.database.entity.User;
import com.example.emmar_assignment.ui.repository.MainRepository;

import java.util.List;
/**
 * Created by Dhanmeet on 11/08/23.
 */
public class MainViewModel extends AndroidViewModel {
    private final MainRepository mainRepository;
    private final LiveData<List<User>> getAllUsers;

    public MainViewModel(@NonNull Application application) {
        super(application);
        // creating instance for MainRepository
        mainRepository = new MainRepository(application);
        getAllUsers = mainRepository.getGetAllLocalUsers();
    }

    public void FetchAndSaveUserData() {
        mainRepository.saveUserData();
    }

    // returning all users to observe on UI
    public LiveData<List<User>> getGetAllUsers() {
        return getAllUsers;
    }
}