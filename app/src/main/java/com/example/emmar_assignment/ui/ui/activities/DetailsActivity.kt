package com.example.emmar_assignment.ui.ui.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.emmar_assignment.R
import com.example.emmar_assignment.databinding.ActivityDetailsBinding
import com.example.emmar_assignment.ui.utils.Constants
import com.example.emmar_assignment.ui.entity.User
import com.google.gson.Gson

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        binding.user = getBundleData()
    }

    private fun getBundleData(): User {
        val data = intent.getStringExtra(Constants.USER_BUNDLE_DATA)
        return Gson().fromJson(data, User::class.java)
    }

    fun onBackPress(v: View) {
        finish()
    }
}