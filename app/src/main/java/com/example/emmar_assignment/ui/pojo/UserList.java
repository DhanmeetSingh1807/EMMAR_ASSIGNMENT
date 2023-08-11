package com.example.emmar_assignment.ui.pojo;

import com.example.emmar_assignment.ui.pojo.Result;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    @SerializedName("results")
    @Expose
    public ArrayList<Result> users;
}