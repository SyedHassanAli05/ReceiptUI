package com.myapplication.obittechgui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.myapplication.obittechgui.Model.User
import com.myapplication.obittechgui.utlis.LocalPreferance

class MainActivity : AppCompatActivity() {
    lateinit var continue_btn:Button


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findView()
        OnClickListner()


    }

    private fun findView()
    {

        continue_btn=findViewById(R.id.continue_btn)
    }


    private fun OnClickListner() {
        Handler(Looper.getMainLooper()).postDelayed({

            if (LocalPreferance.shared.islogin==true) {
                startActivity(Intent(this, MainFragmentNavActivity::class.java))
                finishAffinity()

            } else{

            continue_btn.setVisibility(View.VISIBLE)

        }

        }, 1000)

        continue_btn.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
            finish()
        }


    }




}