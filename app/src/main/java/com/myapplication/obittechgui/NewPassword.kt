package com.myapplication.obittechgui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class NewPassword : AppCompatActivity() {

    lateinit var back:ImageView
    lateinit var newpassword_savebtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_password)

        findView()
        onBackPress()
        onClickListner()
    }
    private fun findView()
    {
        back=findViewById(R.id.back_newpassword)
        newpassword_savebtn=findViewById(R.id.new_pss_savebtn)
    }

    private fun onClickListner()
    {
        newpassword_savebtn.setOnClickListener {

            val intent=Intent(this,MainFragmentNavActivity::class.java)
            startActivity(intent)
        }
    }

    private fun onBackPress(){
        back.setOnClickListener {
            onBackPressed()
        }
    }


}