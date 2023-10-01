package com.myapplication.obittechgui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ForgotPasswordActivity : AppCompatActivity() {

    lateinit var viamail:TextView
    lateinit var viaphone:TextView
    lateinit var back_forgetpassword:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        findView()
        onClickListner()
        onBackPress()
    }

    private fun findView()
    {
        viaphone=findViewById(R.id.textview_viaphone)
        viamail=findViewById(R.id.textview_viamail)
        back_forgetpassword=findViewById(R.id.forgetpss_back)
    }

    private fun onClickListner()
    {
        viaphone.setOnClickListener {
            val intent=Intent(this,EnterPhoneNumberActivity::class.java)
            startActivity(intent)
        }

        viamail.setOnClickListener {
            val intent=Intent(this,EnterEmail::class.java)
            startActivity(intent)
        }

    }

    private fun onBackPress(){
        back_forgetpassword.setOnClickListener {
            onBackPressed()
        }

    }
}
