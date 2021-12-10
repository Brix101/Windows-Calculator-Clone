package com.brix.windowscalculatorclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnPlusMinus: Button
    private lateinit var btnZero: Button
    private lateinit var btnDot: Button
    private lateinit var btnEquals: Button
    private lateinit var btnOne: Button
    private lateinit var btnTwo: Button
    private lateinit var btnThree: Button
    private lateinit var btnPlus: Button
    private lateinit var btnFour: Button
    private lateinit var btnFive: Button
    private lateinit var btnSix: Button
    private lateinit var btnMinus: Button
    private lateinit var btnSeven: Button
    private lateinit var btnEight: Button
    private lateinit var btnNine: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnClearEntry: Button
    private lateinit var btnClear: Button
    private lateinit var btnBackSpace: Button
    private lateinit var btnDivide: Button

    private lateinit var txtInput: TextView

    private var initialText = true


    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPlusMinus = findViewById(R.id.btnPlusMinus)
        btnZero = findViewById(R.id.btnZero)
        btnDot = findViewById(R.id.btnDot)
        btnEquals = findViewById(R.id.btnEquals)
        btnOne = findViewById(R.id.btnOne)
        btnTwo = findViewById(R.id.btnTwo)
        btnThree = findViewById(R.id.btnThree)
        btnPlus = findViewById(R.id.btnPlus)
        btnFour = findViewById(R.id.btnFour)
        btnFive = findViewById(R.id.btnFive)
        btnSix = findViewById(R.id.btnSix)
        btnMinus = findViewById(R.id.btnMinus)
        btnSeven = findViewById(R.id.btnSeven)
        btnEight = findViewById(R.id.btnEight)
        btnNine = findViewById(R.id.btnNine)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnClearEntry = findViewById(R.id.btnClearEntry)
        btnClear = findViewById(R.id.btnClear)
        btnBackSpace = findViewById(R.id.btnBackSpace)
        btnDivide = findViewById(R.id.btnDivide)

        txtInput = findViewById(R.id.txtInput)

        setListener()
    }

    private fun setListener() {
        btnPlusMinus.setOnClickListener(this)
        btnZero.setOnClickListener(this)
        btnDot.setOnClickListener(this)
        btnEquals.setOnClickListener(this)
        btnOne.setOnClickListener(this)
        btnTwo.setOnClickListener(this)
        btnThree.setOnClickListener(this)
        btnPlus.setOnClickListener(this)
        btnFour.setOnClickListener(this)
        btnFive.setOnClickListener(this)
        btnSix.setOnClickListener(this)
        btnMinus.setOnClickListener(this)
        btnSeven.setOnClickListener(this)
        btnEight.setOnClickListener(this)
        btnNine.setOnClickListener(this)
        btnMultiply.setOnClickListener(this)
        btnClearEntry.setOnClickListener(this)
        btnClear.setOnClickListener(this)
        btnBackSpace.setOnClickListener(this)
        btnDivide.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        var number = txtInput.text.toString()
        if(initialText){
            number = ""
            initialText =false
        }
        if (v != null) {
            when (v.id) {
                R.id.btnOne -> number += "1"
                R.id.btnTwo -> number += "2"
                R.id.btnThree -> number += "3"
                R.id.btnFour -> number += "4"
                R.id.btnFive -> number += "5"
                R.id.btnSix -> number += "6"
                R.id.btnSeven -> number += "7"
                R.id.btnEight -> number += "8"
                R.id.btnNine -> number += "9"
                R.id.btnZero -> number += "0"
                R.id.btnPlusMinus -> number = (number.toInt() * -1).toString()
                R.id.btnDot -> number
                R.id.btnClearEntry -> {
                    number = "0"
                    initialText = true
                }
                R.id.btnClear -> {
                    number = "0"
                    initialText = true
                }
                R.id.btnBackSpace -> number = number.dropLast(1)
            }
            txtInput.text = number
        }
    }

}