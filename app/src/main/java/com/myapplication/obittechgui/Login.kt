package com.myapplication.obittechgui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.myapplication.obittechgui.utlis.LocalPreferance

class Login : AppCompatActivity() {

    /*lateinit var pref : SharedPreferences
    private val pref_name = "SharedPreferences"
    val Is_Login = "IsUserLoggedIn"
    val key_pass = "password"
    val key_email = "email"*/
    lateinit var create_account:TextView
    lateinit var forget_password:TextView
    lateinit var login_btn:Button
    lateinit var edt_email:EditText
    lateinit var edt_password:EditText

//    var etPassword, tvNameSignup, rvReceiptListing

    var isAllFieldChecked=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

       /* fun saveString(uEmail: Any?, uPass: Any?) {
            val editor : SharedPreferences.Editor = pref.edit()
            editor.putBoolean(Is_Login, true)
            editor.putString(key_email, uEmail as String?)
            editor.putString(key_pass, uPass as String?)
            editor.commit()

        }*/

        findView()
        onClickListner()

    }
    private fun findView()
    {
        create_account=findViewById(R.id.textview_create_new)
        forget_password=findViewById(R.id.textview_forgetpassword)
        login_btn=findViewById(R.id.login_button)
        edt_email=findViewById(R.id.email)
        edt_password=findViewById(R.id.password)
       // pref = this.getSharedPreferences(pref_name, Context.MODE_PRIVATE)


    }
    private fun onClickListner()
    {
        create_account.setOnClickListener {
            val intent=Intent(this, CreateAccount::class.java)
            startActivity(intent)
        }

        forget_password.setOnClickListener {
            val intent=Intent(this,ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

       login_btn.setOnClickListener{


            LocalPreferance.shared.islogin=true
           /*val editor : SharedPreferences.Editor = pref.edit()
           editor.putBoolean(Is_Login, true)
           editor.commit()*/

           isAllFieldChecked=CheckAllFields()
           if(isAllFieldChecked){
               val intent=Intent(this, MainFragmentNavActivity::class.java)
               startActivity(intent)
               finishAffinity()
       }
       }

    }
    private fun CheckAllFields(): Boolean {
        if (edt_email.text.isEmpty() || !edt_email.text.toString().matches(Patterns.EMAIL_ADDRESS.toRegex())){
            edt_email.error="Invalid Email address"
            return false
        }


        if(edt_password.length()==0){
            edt_password.error="This field is required"
            return false

        } else if(edt_password.length()<8){
            edt_password.error="Password must contain 8 character"
            return false
        }



        return true

    }

}