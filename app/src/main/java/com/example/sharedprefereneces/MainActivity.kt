package com.example.sharedprefereneces

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sharedprefereneces.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private val sharedPreferences: MySharedPreferences by lazy {
        MySharedPreferences(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setUpListeners()
        displayInputText()
    }

    private fun setUpListeners() {
        binding?.uiBtnNavigateToNextActivity?.setOnClickListener {
            navigateToNextActivity()
        }
    }

    override fun onResume() {
        super.onResume()

    }

    private fun navigateToNextActivity() {
        val intent = Intent(this,ActivityTwo::class.java)
        startActivity(intent)
    }

    private fun displayInputText() {
        Log.d("ResumeState", "displayInputText: ${sharedPreferences.getName()}")
        binding?.uiTvDisplayName?.text = sharedPreferences.getName()
        binding?.uiTvDisplayPassword?.text = sharedPreferences.getPassword()
    }
}