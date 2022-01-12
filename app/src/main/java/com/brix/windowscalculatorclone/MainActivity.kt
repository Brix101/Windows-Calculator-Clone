package com.brix.windowscalculatorclone

import android.os.Bundle
import android.text.method.Touch
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {
    private lateinit var txtInput: TextView
    private lateinit var txtHistory: TextView

    private var isDecimal = false
    private var isOperated = false

    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtInput = findViewById(R.id.txtInput)
        txtHistory = findViewById(R.id.txtHistory)
        txtInput.text = "0"
    }


    fun onNumberClick(view: View?) {
        if (view is Button) {
            if(!isOperated){
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
            }else{
                txtInput.text = ""
                txtInput.append(view.text)
                isOperated = false
            }
        }
    }

    //TODO update Operation function
    fun onOperatorClick(view: View?) {
        if (view != null) {
            val op = ((view as Button).text).toString()
            val number = txtInput.text.toString()
//            txtOperation.text = btn
//            To Set Operation
            isOperated = true
            txtHistory.text = number + op
        }
    }

    fun onClearClick(view: View) {
        txtInput.text = ""
        txtHistory.text = ""
    }

    fun onClearEntryClick(view: View) {
        txtInput.text = ""
    }

    private fun getInputExpression(): String {
        txtHistory.append(txtInput.text)
        var expression = txtHistory.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    //TODO add equals function
    fun onEqualsClick(view: View) {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()

            if (result.isNaN()) {
                // Show Error Message
                Toast.makeText(applicationContext,"Error",Toast.LENGTH_SHORT).show()
            } else {
                // Show Result
                txtInput.text = result.toString()
            }
        } catch (e: Exception) {
            // Show Error Message
            Toast.makeText(applicationContext,e.message,Toast.LENGTH_SHORT).show()
        }
    }

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
            txtInput.text = txtInput.text.dropLast(1)
    }

}