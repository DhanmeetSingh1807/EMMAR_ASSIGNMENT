package com.example.emmar_assignment.ui.network;


import com.example.emmar_assignment.ui.models.UserList;

import retrofit2.Call;
import retrofit2.http.GET;
/**
 * Created by Dhanmeet on 11/08/23.
 */
public interface ApiDataService {
    // end point to fetch user data
    @GET("?results=100")
    Call<UserList> getApiRequestsArray();
}
