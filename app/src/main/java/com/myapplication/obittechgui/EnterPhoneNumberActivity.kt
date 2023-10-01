package com.myapplication.obittechgui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class EnterPhoneNumberActivity : AppCompatActivity() {

    lateinit var phone_sendcode:Button
    lateinit var enterphonenum_backicon: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_phone_number)

        findView()
        onClickListner()
        onBackPress()

    }

    private fun findView()
    {
        phone_sendcode=findViewById(R.id.btn_sendcode)
        enterphonenum_backicon=findViewById(R.id.back_enterphone_num)
    }

    private fun onClickListner()
    {
        phone_sendcode.setOnClickListener {
            val intent=Intent(this,EnterCode::class.java)
            startActivity(intent)
        }
    }

    private fun onBackPress(){
        enterphonenum_backicon.setOnClickListener {
            onBackPressed()
        }

    }
}