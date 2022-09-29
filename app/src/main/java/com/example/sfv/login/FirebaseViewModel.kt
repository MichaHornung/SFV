package com.example.sfv.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sfv.model.User
import com.google.android.material.tabs.TabLayout.TabGravity

const val  TAG = "MAINVIEWMODEL"

class MainViewModel(application: Application) : AndroidViewModel(application){

    private val firebaseAuth = FirebaseAuth.getInstance()

    val db = FirebaseFirestore.getInstance()

    private val _currentUser = MutableLiveData<FirebaseUser?>(firebaseAuth.currentUser)
    val currentUsher: LiveData<FirebaseUser?>
        get() = _currentUser


    private val  _user = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user
}

fun login(benutzername: String, password: String) {
    firebaseAuth.signInWithEmailAndPassword(benutzername, password).addOnCompleteListener {
        if (it.isSuccessful) {
            _currentUser.value = firebaseAuth.currentUser
        } else {
            Log.e(TAG, "Login failed: ${it.exception}")
        }
    }
}

