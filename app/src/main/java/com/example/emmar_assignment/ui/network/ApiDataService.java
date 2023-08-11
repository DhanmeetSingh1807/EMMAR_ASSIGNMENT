package com.example.emmar_assignment.ui.network;


import com.example.emmar_assignment.ui.pojo.UserList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiDataService {
    @GET("?results=100")
    Call<UserList> getApiRequestsArray();
}
