package com.example.projemanag.activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.projemanag.R
import com.example.projemanag.databinding.ActivityBaseBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

open class BaseActivity : AppCompatActivity() {
    private var binding:ActivityBaseBinding?=null

    private var doublePressedOnce=false
    private lateinit var mProgressDialog:Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    fun showProgressDialog(text:String){
        mProgressDialog= Dialog(this)
        mProgressDialog.setContentView(R.layout.dialog_progress)
        mProgressDialog.findViewById<TextView>(R.id.tv_progress_text).text=text
        mProgressDialog.show()

    }
    fun hideProgressBar(){
        mProgressDialog.dismiss()
    }
    fun findCurrentUserId():String{
        return FirebaseAuth.getInstance().currentUser!!.uid
    }

    fun  doubleBackToExit(){
        if (doublePressedOnce){
            super.onBackPressed()
            return
        }
           this.doublePressedOnce=true
        Toast.makeText(this,R.string.please_click_back_again_to_exit,Toast.LENGTH_SHORT).show()

        Handler().postDelayed({doublePressedOnce=false},2000)
    }

    fun showErrorSnackBar(message: String){
        val snackBar=Snackbar.make(findViewById(android.R.id.content),message,Snackbar.LENGTH_LONG)
        val snackBarView=snackBar.view
        snackBarView.setBackgroundColor(ContextCompat.getColor(this, R.color.color_primary))
        snackBar.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }
}