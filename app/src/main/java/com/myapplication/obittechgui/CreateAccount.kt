package com.myapplication.obittechgui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.math.sign

class CreateAccount : AppCompatActivity() {

    lateinit var signup:Button
    lateinit var login:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        findView()
        onClickListner()
    }

    private fun findView()
    {
        signup=findViewById(R.id.signup_btn)
        login=findViewById(R.id.textview_login_here)
    }

    private fun onClickListner()
    {
        signup.setOnClickListener {
            val intent=Intent(this,MainFragmentNavActivity::class.java)
            startActivity(intent)
            finishAffinity()


        }

        login.setOnClickListener {
            val intent=Intent(this, Login::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }
}