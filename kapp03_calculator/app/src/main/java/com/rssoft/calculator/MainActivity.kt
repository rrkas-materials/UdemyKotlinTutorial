package com.rssoft.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var op = ""
    var oldNumber = ""
    var isNewOp = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonAC.setOnClickListener {
            textViewDisplay.text = ""
            op = ""
            isNewOp = false
            oldNumber = ""
        }
    }

    fun numberEvent(view: View) {
        if (isNewOp) {
            textViewDisplay.text = ""
            isNewOp = false
        }
        val buttonClicked = view as Button
        var buttonValue = textViewDisplay.text.toString()
        when (buttonClicked.id) {
            button0.id -> buttonValue += "0"
            button1.id -> buttonValue += "1"
            button2.id -> buttonValue += "2"
            button3.id -> buttonValue += "3"
            button4.id -> buttonValue += "4"
            button5.id -> buttonValue += "5"
            button6.id -> buttonValue += "6"
            button7.id -> buttonValue += "7"
            button8.id -> buttonValue += "8"
            button9.id -> buttonValue += "9"
            buttonDot.id -> {
                buttonValue += "."
            }
            buttonPlusMinus.id -> {
                if (buttonValue.startsWith("-")) {
                    buttonValue = buttonValue.substring(1)
                } else {
                    buttonValue = "-$buttonValue"
                }
            }
        }
        textViewDisplay.text = buttonValue
    }

    fun operatorEvent(view: View) {
        val buttonClicked = view as Button
        oldNumber = textViewDisplay.text.toString()
        when (buttonClicked.id) {
            buttonMultiply.id -> {
                op = "*"
            }
            buttonDiv.id -> {
                op = "/"
            }
            buttonPlus.id -> {
                op = "+"
            }
            buttonMinus.id -> {
                op = "-"
            }
        }
        isNewOp = true
    }

    fun calculateEvent(view: View) {
        val newNum = textViewDisplay.text.toString()
        var result: Double = 0.0
        try {
            when (op) {
                "*" -> {
                    result = oldNumber.toDouble() * newNum.toDouble()
                }
                "/" -> {
                    result = oldNumber.toDouble() / newNum.toDouble()
                }
                "+" -> {
                    result = oldNumber.toDouble() + newNum.toDouble()
                }
                "-" -> {
                    result = oldNumber.toDouble() - newNum.toDouble()
                }
            }
        } catch (e: Exception) {
            Toast.makeText(view.context, e.message, Toast.LENGTH_SHORT).show()
            println(e.message)
        }
        textViewDisplay.text = result.toString()
        isNewOp = true
    }

    fun percentEvent(view: View) {
        try {
            val num = textViewDisplay.text.toString().toDouble() / 100
            textViewDisplay.text = num.toString()
        } catch (e: Exception) {
            Toast.makeText(view.context, e.message, Toast.LENGTH_SHORT).show()
            println(e.message)
        }
    }
}