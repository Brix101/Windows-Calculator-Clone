package com.brix.windowscalculatorclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnPlusMinus: Button
    lateinit var btnZero: Button
    lateinit var btnDot: Button
    lateinit var btnEquals: Button
    lateinit var btnOne: Button
    lateinit var btnTwo: Button
    lateinit var btnThree: Button
    lateinit var btnPlus: Button
    lateinit var btnFour: Button
    lateinit var btnFive: Button
    lateinit var btnSix: Button
    lateinit var btnMinus: Button
    lateinit var btnSeven: Button
    lateinit var btnEight: Button
    lateinit var btnNine: Button
    lateinit var btnMultiply: Button
    lateinit var btnClearEntry: Button
    lateinit var btnClear: Button
    lateinit var btnBackSpace: Button
    lateinit var btnDivide: Button

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

        setListener()
    }
    private  fun setListener(){
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
        Toast.makeText(this, (v as Button).text, Toast.LENGTH_SHORT).show()
//        when(v?.id){
//            R.id.btnPlusMinus ->{
//
//            }
//        }
    }
}