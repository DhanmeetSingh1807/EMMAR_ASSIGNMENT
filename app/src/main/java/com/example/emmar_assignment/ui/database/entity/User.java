package com.example.emmar_assignment.ui.database.entity;

import static com.example.emmar_assignment.ui.utils.Utils.getDate;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by Dhanmeet on 11/08/23.
 */
// Table for storing user Info
@Entity(tableName = "User", indices = @Index(value = {"id"}, unique = true))
public class User {
    @PrimaryKey(autoGenerate = true)
    public Integer id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "image")
    public String image;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "country")
    public String country;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "dob")
    public String dob;

    @ColumnInfo(name = "city")
    public String city;

    @ColumnInfo(name = "state")
    public String state;

    @ColumnInfo(name = "postcode")
    public String postcode;

    @ColumnInfo(name = "age")
    public String age;

    public String getDobDate(){
        return "Dob : " + getDate(dob);
    }

    public String getDetailEmail() {
        return "Email : " + email;
    }

    public String dateJoined() {
        return "Date Joined : " + getDate(date);
    }

    public String userJoinedDate(){
        return getDate(date);
    }

    public String getCity() {
        return "City : " + city;
    }

    public String getState() {
        return "State : " + state;
    }

    public String getUserCountry() {
        return "Country | " + country;
    }

    public String getDetailCountry() {
        return "Country : " + country;
    }

    public String getPostCode() {
        return "Postcode : " + postcode;
    }

    public User(String name, String image, String email, String country, String date, String dob, String city, String state, String postcode,String age) {
        this.name = name;
        this.image = image;
        this.email = email;
        this.country = country;
        this.date = date;
        this.dob = dob;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.age = age ;
    }

    @BindingAdapter({"avatar"})
    public static void loadImage(ImageView imageView, String imageURL) {
        Glide.with(imageView.getContext())
                .setDefaultRequestOptions(new RequestOptions()
                        .circleCrop())
                .load(imageURL)
                .into(imageView);
    }
}