package com.examplelogin.bottom_nav

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    var edtId: EditText? = null
    var edtPass: EditText? = null
    var readId: TextView? = null
    var readPass: TextView? = null
    var myContext = "myFile"
    private var mIsShowPass = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtId = findViewById(R.id.idUser)
        edtPass = findViewById(R.id.idPass)
        readId = findViewById(R.id.txtId)
        readPass = findViewById(R.id.txtPass)

        visibility.setOnClickListener{
            mIsShowPass = !mIsShowPass
            showPassword(mIsShowPass)
        }
        showPassword(mIsShowPass)

        idCard.setOnClickListener { saveFile() }
        val btnRead = findViewById<CardView>(R.id.idRead)
        btnRead.setOnClickListener { readFile() }

    }
    private fun saveFile() {
        val strName = edtId!!.text.toString()
        val sharedPref1 = getSharedPreferences(myContext, Context.MODE_PRIVATE)
        val editor1 = sharedPref1.edit()
        editor1.putString("name", strName)
        editor1.commit()

        val strPass = edtPass!!.text.toString()
        val sharedPref2 = getSharedPreferences(myContext, Context.MODE_PRIVATE)
        val editor2 = sharedPref2.edit()
        editor2.putString("pass", strPass)
        editor2.commit()
    }
    private fun readFile() {
        val sharedPref1 = getSharedPreferences(myContext, Context.MODE_PRIVATE)
        val defaultValue1 = "DefaultName"
        val name = sharedPref1.getString("name", defaultValue1)
        readId!!.text = "Name: $name"

        val sharedPref2 = getSharedPreferences(myContext, Context.MODE_PRIVATE)
        val defaultValue2 = "DefaultPass"
        val pass = sharedPref2.getString("pass", defaultValue2)
        readPass!!.text = "Password: $pass"
    }

    private fun showPassword(isShow: Boolean) {
        if (isShow) {
            // To show the password
            idPass.transformationMethod = HideReturnsTransformationMethod.getInstance()
            visibility.setImageResource(R.drawable.show_password)
        } else {
            // To hide the password
            idPass.transformationMethod = PasswordTransformationMethod.getInstance()
            visibility.setImageResource(R.drawable.hide_password)
        }
        // To put the pointer at the end of the password string
        idPass.setSelection(idPass.text.toString().length)
    }

}