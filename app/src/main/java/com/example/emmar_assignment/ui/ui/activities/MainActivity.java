package com.example.emmar_assignment.ui.ui.activities;

import static com.example.emmar_assignment.ui.utils.Constants.USER_BUNDLE_DATA;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emmar_assignment.R;
import com.example.emmar_assignment.databinding.ActivityMainBinding;
import com.example.emmar_assignment.ui.entity.User;
import com.example.emmar_assignment.ui.ui.adapter.RecylerViewAdapter;
import com.example.emmar_assignment.ui.viewmodel.MainViewModel;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private MainActivity mainActivity;
    private MainViewModel mainViewModel;
    private RecylerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        setUpRecylerView();
        mainViewModel.FetchAndSaveUserData();
        getAllUsers();
    }

    private void initView() {
        mainActivity = this;
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    private void setUpRecylerView() {
        RecyclerView recyclerView = activityMainBinding.viewdeveloper;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new RecylerViewAdapter(user -> startActivity(new Intent(mainActivity, DetailsActivity.class)
                .putExtra(USER_BUNDLE_DATA, new Gson().toJson(user))));
        recyclerView.setAdapter(adapter);
    }

    private void getAllUsers() {
        mainViewModel.getGetAllUsers().observe(this, userList ->
                adapter.setUserList((ArrayList<User>) userList));
    }

    public void onBackPress(View v) {
        finish();
    }
}