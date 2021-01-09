package com.example.composejetpackmvvmproject.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.composejetpackmvvmproject.R
import com.example.composejetpackmvvmproject.ui.fragment.CustomViewWithComposeFragment

class MainComposeJetpackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view_with_compose_jetpack)

//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.placeholder, CustomViewWithComposeFragment())
//            .commit()

    }
}