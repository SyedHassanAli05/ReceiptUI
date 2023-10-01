package com.myapplication.obittechgui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class EnterCode : AppCompatActivity() {
    lateinit var entercode_btn:Button
    lateinit var entercode_backicon:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_code)

        findView()
        onClickListner()
        onBackPress()
    }

    private fun findView()
    {
        entercode_btn=findViewById(R.id.entercode_cont_btn)
        entercode_backicon=findViewById(R.id.back_entercode)
    }

    private fun onClickListner()
    {
        entercode_btn.setOnClickListener {
            val intent=Intent(this,NewPassword::class.java)
            startActivity(intent)
        }
    }

    private fun onBackPress(){
        entercode_backicon.setOnClickListener {
            onBackPressed()
        }

    }
}