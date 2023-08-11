package com.example.emmar_assignment.ui.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.emmar_assignment.ui.utils.AppExecutors;
import com.example.emmar_assignment.ui.database.dao.UserDao;
import com.example.emmar_assignment.ui.database.AppDatabase;
import com.example.emmar_assignment.ui.database.entity.User;
import com.example.emmar_assignment.ui.network.ApiDataService;
import com.example.emmar_assignment.ui.network.RetrofitClient;
import com.example.emmar_assignment.ui.models.Result;
import com.example.emmar_assignment.ui.models.UserList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * Created by Dhanmeet on 11/08/23.
 */
public class MainRepository {

    private final AppDatabase database;

    private final LiveData<List<User>> getAllLocalUsers;

    public MainRepository(Application application) {
        // getting database instance
        database = AppDatabase.getInstance(application);
        // getting all users stored in database
        getAllLocalUsers = database.userDao().getAllUsers();
    }

    public LiveData<List<User>> getGetAllLocalUsers()
    {
        return getAllLocalUsers;
    }

    // getting all users data from api call
    public void saveUserData(){
        final ApiDataService userDataService = RetrofitClient.getService();

        userDataService.getApiRequestsArray().enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                // all users fetched from Api call
                List<Result> userList = response.body().users;
                createUserDataTable(userList);
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {

            }
        });
    }

    // storing all values needed for UI in User Table from API data
    private void createUserDataTable(List<Result> userList) {
        ArrayList<User> localUsers = new ArrayList<>();
        for (Result userData : userList) {
            User user = new User(userData.name.first, userData.picture.large, userData.email, userData.location.country, userData.registered.date.toString(), userData.dob.date.toString(), userData.location.city, userData.location.state, userData.location.postcode,String.valueOf(userData.dob.age));
            localUsers.add(user)  ;
        }

        // Using Executor service for inserting user data in background
        new AppExecutors().diskIO().execute(() -> {
           UserDao userDao = database.userDao();
           userDao.insert(localUsers);
        });
    }
}