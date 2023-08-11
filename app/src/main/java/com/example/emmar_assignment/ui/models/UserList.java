package com.example.emmar_assignment.ui.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
/**
 * Created by Dhanmeet on 11/08/23.
 */
public class UserList {
    @SerializedName("results")
    @Expose
    public ArrayList<Result> users;
}