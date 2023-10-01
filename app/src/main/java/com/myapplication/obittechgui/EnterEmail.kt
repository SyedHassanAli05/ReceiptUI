package com.myapplication.obittechgui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class EnterEmail : AppCompatActivity() {
    lateinit var sendcode:Button
    lateinit var enteremail_backicon:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_email)

        findView()
        onClickListner()
        onBackPress()
    }

    private fun findView()
    {
        sendcode=findViewById(R.id.send_code)
        enteremail_backicon=findViewById(R.id.back_enteremail)
    }

    private fun onClickListner()
    {
        sendcode.setOnClickListener {
            val intent=Intent(this,EnterCode::class.java)
            startActivity(intent)
        }
    }

    private fun onBackPress() {
        enteremail_backicon.setOnClickListener {
            onBackPressed()
        }
    }
}