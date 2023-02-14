package com.example.sharedprefereneces

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedprefereneces.databinding.ActivityTwoBinding

class ActivityTwo : AppCompatActivity() {
    private var binding: ActivityTwoBinding? =null
    private val sharedPreferences: MySharedPreferences by lazy {
        MySharedPreferences(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwoBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setUpListeners()
    }

    private fun saveToSharedPreferences() {
        val name: String = binding?.uiEtName?.text.toString().trim()
        val password: String = binding?.uiEtPassword?.text.toString().trim()

        sharedPreferences.setName(name)
        sharedPreferences.setPassword(password)
    }

    private fun setUpListeners() {
        binding?.uiBtnSubmit?.setOnClickListener {
            saveToSharedPreferences()
            navigateToPreviousActivity()
        }
    }

    private fun navigateToPreviousActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent)
        finish()
    }
}