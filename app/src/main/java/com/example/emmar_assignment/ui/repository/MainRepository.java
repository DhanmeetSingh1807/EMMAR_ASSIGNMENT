package com.example.emmar_assignment.ui.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.emmar_assignment.ui.utils.AppExecutors;
import com.example.emmar_assignment.ui.dao.UserDao;
import com.example.emmar_assignment.ui.database.AppDatabase;
import com.example.emmar_assignment.ui.entity.User;
import com.example.emmar_assignment.ui.network.ApiDataService;
import com.example.emmar_assignment.ui.network.RetrofitClient;
import com.example.emmar_assignment.ui.pojo.Result;
import com.example.emmar_assignment.ui.pojo.UserList;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {

    private final AppDatabase database;

    private final LiveData<List<User>> getAllLocalUsers;

    public MainRepository(Application application) {
        database = AppDatabase.getInstance(application);
        getAllLocalUsers = database.userDao().getAllUsers();

    }

    public LiveData<List<User>> getGetAllLocalUsers()
    {
        return getAllLocalUsers;
    }

    public void saveUserData(){

        final ApiDataService userDataService = RetrofitClient.getService();

        userDataService.getApiRequestsArray().enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                List<Result> userList = response.body().users;
                createUserDataTable(userList);
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {

            }
        });
    }

    private void createUserDataTable(List<Result> userList) {
        ArrayList<User> localUsers = new ArrayList<>();
        for (Result userData : userList) {
            User user = new User(userData.name.first, userData.picture.large, userData.email, userData.location.country, userData.registered.date.toString(), userData.dob.date.toString(), userData.location.city, userData.location.state, userData.location.postcode,String.valueOf(userData.dob.age));
            localUsers.add(user)  ;
        }
        new AppExecutors().diskIO().execute(() -> {
           UserDao userDao = database.userDao();
           userDao.insert(localUsers);
        });
    }
}