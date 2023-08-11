package com.example.emmar_assignment.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.emmar_assignment.ui.entity.User;
import com.example.emmar_assignment.ui.repository.MainRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private final MainRepository mainRepository;
    private final LiveData<List<User>> getAllUsers;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mainRepository = new MainRepository(application);
        getAllUsers = mainRepository.getGetAllLocalUsers();
    }

    public void FetchAndSaveUserData() {
        mainRepository.saveUserData();
    }

    public LiveData<List<User>> getGetAllUsers() {
        return getAllUsers;
    }
}
