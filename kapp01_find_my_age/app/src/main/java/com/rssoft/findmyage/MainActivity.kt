package com.rssoft.findmyage

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewAge.text = "Enter DOB and press Find Age"
        buttonFindAge.setOnClickListener {
            val dob = editTextYear.text.toString().toInt()
            val nowYear = Calendar.getInstance().get(Calendar.YEAR)
            if (nowYear < dob) {
                textViewAge.text = "Invalid DOB!"
            } else {
                textViewAge.text = "${nowYear - dob} years"
            }
        }
    }
}