package com.brix.windowscalculatorclone

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var txtInput: TextView
    private lateinit var txtOperation: TextView
    private lateinit var txtHistory: TextView

    private var isDecimal = false

    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtInput = findViewById(R.id.txtInput)
        txtOperation = findViewById(R.id.txtOperation)
        txtHistory = findViewById(R.id.txtHistory)
        txtInput.text = "0"
    }


    fun onNumberClick(view: View?) {
        if (view is Button) {
            val txtOp = txtOperation.text.toString()
            if(txtOp.isEmpty()){
                isDecimal = txtInput.text.toString().contains(".")
                if (view.text == ".") {
                    if (!isDecimal) txtInput.append(view.text)
                } else {
                    txtInput.append(view.text)
                    if (!isDecimal) {
                        val num = txtInput.text.toString().toIntOrNull()
                        if (num != null) {
                            txtInput.text = (num * 1).toString()
                        }
                    }
                }
            }
        }
    }

    //TODO update Operation function
    fun onOperatorClick(view: View?) {
        if (view != null) {
            val btn = ((view as Button).text).toString()
            txtOperation.text = btn
        }
    }

    //TODO update clear all function
    fun onClearClick(view: View) {
        txtInput.text = ""
    }

    fun onClearEntryClick(view: View) {
        txtInput.text = ""
    }

    //TODO add equals function
    fun onEqualsClick(view: View) {}

    fun onPlusMinusClick(view: View) {
        isDecimal = txtInput.text.toString().contains(".")
        if (isDecimal) {
            val doubleNum = txtInput.text.toString().toDoubleOrNull()
            if (doubleNum != null) {
                txtInput.text = (doubleNum * -1).toString()
            }
        } else {
            val intNum = txtInput.text.toString().toIntOrNull()
            if (intNum != null) {
                txtInput.text = (intNum * -1).toString()
            }
        }
    }

    fun onBackSpaceClick(view: View) {
        val txtOp = txtOperation.text.toString()
        if(txtOp.isNotEmpty()){
            txtOperation.text = ""
        }else{
            txtInput.text = txtInput.text.dropLast(1)
        }
    }

}