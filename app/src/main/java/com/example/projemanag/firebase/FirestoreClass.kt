package com.example.projemanag.firebase

import android.util.Log
import com.example.projemanag.activities.SignInActivity
import com.example.projemanag.activities.SignUpActivity
import com.example.projemanag.models.User
import com.example.projemanag.utils.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class FirestoreClass {

    private var mFirestore = FirebaseFirestore.getInstance()

    fun registerUser(activity: SignUpActivity, userInfo: User) {
        mFirestore.collection(Constants.USERS).document(getCurrentUserId())
            .set(userInfo,SetOptions.merge())
            .addOnSuccessListener {
                activity.userRegisteredSuccess()
            }
            .addOnFailureListener {
                e->
                Log.e(activity.javaClass.simpleName, "Error writing documentation ",e)
            }
    }

    fun signInUser(activity: SignInActivity){
        mFirestore.collection(Constants.USERS).document(getCurrentUserId())
            .get()
            .addOnSuccessListener {
                document->
                val loggedInUSer=document.toObject(User::class.java)
                if (loggedInUSer!=null){
                    activity.signInSuccess(loggedInUSer)
                }

            }
            .addOnFailureListener {
                    e->
                Log.e(activity.javaClass.simpleName, "Error with ", e)
            }
    }
    fun getCurrentUserId():String{
        val currentUser=FirebaseAuth.getInstance().currentUser
        var currentUserId=""

        if (currentUser!=null){
            currentUserId=currentUser.uid
        }
        return currentUserId
    }
}