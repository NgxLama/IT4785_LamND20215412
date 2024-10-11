package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var textReuslt: TextView
    lateinit var topText: TextView

    var state: Int = 1
    var op: Int = 0
    var op1: Int = 0
    var op2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.constraint_layout)

        textReuslt = findViewById(R.id.display)
        topText = findViewById(R.id.top_display)

        findViewById<Button>(R.id.button_0).setOnClickListener(this)
        findViewById<Button>(R.id.button_1).setOnClickListener(this)
        findViewById<Button>(R.id.button_2).setOnClickListener(this)
        findViewById<Button>(R.id.button_3).setOnClickListener(this)
        findViewById<Button>(R.id.button_4).setOnClickListener(this)
        findViewById<Button>(R.id.button_5).setOnClickListener(this)
        findViewById<Button>(R.id.button_6).setOnClickListener(this)
        findViewById<Button>(R.id.button_7).setOnClickListener(this)
        findViewById<Button>(R.id.button_8).setOnClickListener(this)
        findViewById<Button>(R.id.button_9).setOnClickListener(this)
        findViewById<Button>(R.id.button_plus).setOnClickListener(this)
        findViewById<Button>(R.id.button_minus).setOnClickListener(this)
        findViewById<Button>(R.id.button_multiply).setOnClickListener(this)
        findViewById<Button>(R.id.button_divide).setOnClickListener(this)
        findViewById<Button>(R.id.button_plus_minus).setOnClickListener(this)
        findViewById<Button>(R.id.button_ce).setOnClickListener(this)
        findViewById<Button>(R.id.button_c).setOnClickListener(this)
        findViewById<Button>(R.id.button_bs).setOnClickListener(this)
        findViewById<Button>(R.id.button_equals).setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val id = p0?.id
        if (id == R.id.button_0) {
            addDigit(0)
        } else if (id == R.id.button_1) {
            addDigit(1)
        } else if (id == R.id.button_2) {
            addDigit(2)
        } else if (id == R.id.button_3) {
            addDigit(3)
        } else if (id == R.id.button_4) {
            addDigit(4)
        } else if (id == R.id.button_5) {
            addDigit(5)
        } else if (id == R.id.button_6) {
            addDigit(6)
        } else if (id == R.id.button_7) {
            addDigit(7)
        } else if (id == R.id.button_8) {
            addDigit(8)
        } else if (id == R.id.button_9) {
            addDigit(9)
        } else if (id == R.id.button_plus) {
            op = 1
            state = 2
            topText.text = "$op1 +"
            textReuslt.text = "$op2"
        } else if (id == R.id.button_minus) {
            op = 2
            state = 2
            topText.text = "$op1 -"
            textReuslt.text = "$op2"
        } else if (id == R.id.button_multiply) {
            op = 3
            state = 2
            topText.text = "$op1 x"
            textReuslt.text = "$op2"
        } else if (id == R.id.button_divide) {
            op = 4
            state = 2
            topText.text = "$op1 /"
            textReuslt.text = "$op2"
        } else if (id == R.id.button_equals) {
            var result = 0
            if (op == 1) {
                result = op1 + op2
            }
            if (op == 2) {
                result = op1 - op2
            }
            if (op == 3) {
                result = op1 * op2
            }
            if (op == 4) {
                result = op1 / op2
            }
            textReuslt.text = "$result"
            topText.text = ""
            state = 1
            op1 = result
            op2 = 0
            op = 0
        } else if (id == R.id.button_ce) {
            if (state == 1) {
                op1 = 0
                textReuslt.text = "$op1"
            }
            else {
                op2 = 0
                textReuslt.text = "$op2"
            }
        } else if (id == R.id.button_plus_minus) {
            if (state == 1) {
                op1 = -op1
                textReuslt.text = "$op1"
            }
            else {
                op2 = -op2
                textReuslt.text = "$op2"
            }
        } else if (id == R.id.button_c) {
            op1 = 0
            op2 = 0
            state = 1
            op = 0
            textReuslt.text = "$op1"
            topText.text = ""
        } else if (id == R.id.button_bs) {
            if (state == 1) {
                op1 /= 10
                textReuslt.text = "$op1"
            }
            else {
                op2 /= 10
                textReuslt.text = "$op2"
            }
        }

    }

    fun addDigit(c: Int) {
        if (state == 1) {
            if (op1 >= 0) op1 = op1 * 10 + c
            else op1 = - ((-op1) * 10 + c)
            textReuslt.text = "$op1"
        } else {
            if (op2 >= 0) op2 = op2 * 10 + c
            else op2 = - ((-op2) * 10 + c)
            textReuslt.text = "$op2"
        }
    }
}