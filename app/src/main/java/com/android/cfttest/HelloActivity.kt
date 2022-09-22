package com.android.cfttest

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class HelloActivity : AppCompatActivity() {
    private lateinit var button: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)
        var name = "name";
        var surname = "surname";
        val dialog = Dialog(this)
        button = findViewById(R.id.buttonHello);

        name = intent.getStringExtra("name").toString()
        surname = intent.getStringExtra("surname").toString()

        dialog.setContentView(R.layout.activity_window)
        val text: TextView = dialog.findViewById(R.id.helloName)
        text.text = "Hello, $name $surname"

        button.setOnClickListener {
            dialog.show()
        }


    }
}