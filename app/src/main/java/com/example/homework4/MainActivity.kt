package com.example.homework4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.sqrt

class MainActivity : AppCompatActivity() {
    var isNewOp=true
    var oldNumber = ""
    var op = "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberEvent(view: View) {
        if (isNewOp)
            editText.setText("")
        isNewOp = false
        var buClick : String = editText.text.toString()
        var buSelect:Button = view as Button
        when(buSelect.id){
            bu0.id -> {buClick += "0"}
            bu1.id -> {buClick += "1"}
            bu2.id -> {buClick += "2"}
            bu3.id -> {buClick += "3"}
            bu4.id -> {buClick += "4"}
            bu5.id -> {buClick += "5"}
            bu6.id -> {buClick += "6"}
            bu7.id -> {buClick += "7"}
            bu8.id -> {buClick += "8"}
            bu9.id -> {buClick += "9"}
            buDot.id -> {buClick += "."}
            plusMinus.id -> {buClick = "-$buClick"}
        }
        editText.setText(buClick)
    }

    fun operatorEvent(view: View) {
        isNewOp = true
        oldNumber = editText.text.toString()
        var buSelect:Button = view as Button
        when(buSelect.id){
            buMultiply.id -> {op = "*"}
            buPlus.id -> {op = "+"}
            buMinus.id -> {op = "-"}
            byDivide.id -> {op = "/"}
        }
    }

    fun equalEvent(view: View) {
        var newNumber:String = editText.text.toString()
        var result = 0.0
        when(op){
            "+" -> {result = oldNumber.toDouble() + newNumber.toDouble()}
            "*" -> {result = oldNumber.toDouble() * newNumber.toDouble()}
            "/" -> {result = oldNumber.toDouble() / newNumber.toDouble()}
            "-" -> {result = oldNumber.toDouble() - newNumber.toDouble()}
        }
        editText.setText(result.toString())
    }

    fun cEvent(view: View) {
        editText.setText("0")
        isNewOp = true
    }

    fun percentEvent(view: View) {
        var no:Double = editText.text.toString().toDouble()/100
        editText.setText(no.toString())
        isNewOp = true
    }

    fun sqrtEvent(view: View) {
        var no:Double = sqrt(editText.text.toString().toDouble())
        editText.setText(no.toString())
        isNewOp = true
    }
}