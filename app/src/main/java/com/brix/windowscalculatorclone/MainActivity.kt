package com.brix.windowscalculatorclone

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.text.method.Touch
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var txtInput: TextView

    private var initialText = true
    private var isDecimal = false

    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtInput = findViewById(R.id.txtInput)
        txtInput.text = "0"
    }


    fun onNumberClick(view: View?) {
        if (initialText) {
            txtInput.text = "0"
            initialText = false
        }
        if (view is Button) {
            isDecimal = txtInput.text.toString().contains(".")
            if (view.text == ".") {
                if (!isDecimal) txtInput.append(view.text)

            } else
                txtInput.append(view.text)
        }
    }

    fun onOperatorClick(view: View?) {
        Log.d(TAG, "onOperatorClick: " + (view as Button).text)
    }



    fun onClearClick(view: View) {
        txtInput.text = ""
    }

    fun onClearEntryClick(view: View) {
        txtInput.text = ""
    }

    fun onEqualsClick(view: View) {}
    fun onPlusMinusClick(view: View) {
        isDecimal = txtInput.text.toString().contains(".")
        if(isDecimal){
            txtInput.text = (txtInput.text.toString().toDouble()*-1).toString()
        }else{
            txtInput.text = (txtInput.text.toString().toInt()*-1).toString()
        }
    }

    fun onBackSpaceClick(view: View) {
        txtInput.text = txtInput.text.dropLast(1)
    }
}