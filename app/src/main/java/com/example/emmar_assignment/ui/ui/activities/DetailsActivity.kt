package com.example.emmar_assignment.ui.ui.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.emmar_assignment.R
import com.example.emmar_assignment.databinding.ActivityDetailsBinding
import com.example.emmar_assignment.ui.utils.Constants
import com.example.emmar_assignment.ui.database.entity.User
import com.google.gson.Gson
/**
 * Created by Dhanmeet on 11/08/23.
 */
class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)

        // setting selected user details through data binding
        binding.user = getBundleData()
    }

    // getting selected user data in bundle from userList.
    private fun getBundleData(): User {
        val data = intent.getStringExtra(Constants.USER_BUNDLE_DATA)
        return Gson().fromJson(data, User::class.java)
    }

    fun onBackPress(v: View) {
        finish()
    }
}