package com.android.cfttest

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var etDate: EditText
    private lateinit var etName: EditText
    private lateinit var etSurname: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var etConfirm: Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etDate = findViewById(R.id.birthday)
        etName = findViewById(R.id.name)
        etSurname = findViewById(R.id.surname)
        etPassword = findViewById(R.id.password)
        etConfirmPassword = findViewById(R.id.confirm_password)
        etConfirm = findViewById(R.id.btmConfirm)

        etConfirm.setOnClickListener {
            val name = etName.text.toString().trim()
            val surname = etSurname.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()

            if (name.isEmpty() || name.length < 2) {
                etName.error = "Name Required"
                return@setOnClickListener
            } else if (surname.isEmpty() || surname.length < 2) {
                etSurname.error = "Surname Required"
                return@setOnClickListener
            } else if (!(Regex("[a-zA-Z1-9]{6,20}").matches(password))) {
                etPassword.error = "Password Invalid"
                return@setOnClickListener
            } else if (etDate.text.isEmpty()) {
                etDate.error = "Passwords doesn't match"
                return@setOnClickListener
            } else if (confirmPassword.isEmpty() || confirmPassword != password) {
                etConfirmPassword.error = "Passwords doesn't match"
                return@setOnClickListener
            } else {
                Toast.makeText(this, "Registration is success", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity, HelloActivity::class.java)
                intent.putExtra("name", name.toString())
                intent.putExtra("surname", surname.toString())
                startActivity(intent)
            }
        }

        etDate.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    etDate.setText(dat)
                },
                year,
                month,
                day
            )

            datePickerDialog.show()
        }
    }

}