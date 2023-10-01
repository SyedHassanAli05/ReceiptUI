package com.myapplication.obittechgui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ContactUsActivity : AppCompatActivity() {

    lateinit var contactus_backarrow: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)

        findView()
        onBackPress()
    }

    private fun findView() {
        contactus_backarrow = findViewById(R.id.contactus_back)

    }

    private fun onBackPress()
    {
        contactus_backarrow.setOnClickListener {
            onBackPressed()
        }
    }
}