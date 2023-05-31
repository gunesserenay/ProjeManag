package com.example.projemanag

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projemanag.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private var binding:ActivitySignInBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }
}