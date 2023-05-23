package com.example.projemanag

import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import com.example.projemanag.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private var binding:ActivitySplashBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            @Suppress("DEPRECATION")
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        val typeface= Typeface.createFromAsset(assets,"Monoton-Regular.ttf")
        binding?.tvAppName?.typeface=typeface

    }

    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }
}