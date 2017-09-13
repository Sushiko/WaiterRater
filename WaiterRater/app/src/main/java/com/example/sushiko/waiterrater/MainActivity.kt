// Abe Choi - Waiter Rater
// Assignment 0 - Tip Calculator

package com.example.sushiko.waiterrater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.NumberPicker
import java.text.DecimalFormat

import com.example.sushiko.waiterrater.R.id.et_input
import com.example.sushiko.waiterrater.R.id.np_rating
import com.example.sushiko.waiterrater.R.id.tv_output

class MainActivity : AppCompatActivity() {

    private var outputTextView: TextView? = null
    private var inputEditText: EditText? = null
    private var enterButton: Button? = null
    private var np: NumberPicker? = null
    var cost: Double = 0.toDouble()

    internal var fm = DecimalFormat("$#,###,##0.00")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create some references
        this.outputTextView = findViewById(tv_output) as TextView
        this.inputEditText = findViewById(et_input) as EditText
        this.enterButton = findViewById(R.id.btn_enter) as Button
        this.np = findViewById(np_rating) as NumberPicker

        np!!.minValue = 1
        np!!.maxValue = 10

        this.enterButton!!.setOnClickListener {
            // Turn input into a string then into variable cost as a float
            var myStr = inputEditText!!.text.toString()

            try {
                cost = java.lang.Float.parseFloat(myStr).toDouble()
            } catch (e: Exception) {
                cost = 0.0
            }

            val rating = np!!.value
            var tip = 0.00

            if (rating > 0 && rating < 4) {
                tip = cost * .1
            } else if (rating > 3 && rating < 6) {
                tip = cost * .13
            } else if (rating > 5 && rating < 8) {
                tip = cost * .15
            } else if (rating > 7 && rating < 10) {
                tip = cost * .2
            } else if (rating == 10) {
                tip = cost * .25
            }

            // output message
            myStr = "Your bill was " + fm.format(cost)
            myStr = "$myStr\nand you rated your service $rating/10."
            myStr = myStr + "\nYou should tip " + fm.format(tip) + "."

            if (cost < 1 || cost > 100000) {
                outputTextView!!.text = "Error: Please enter a value from 1 to 100,000"
            } else
                outputTextView!!.text = myStr
        }
    }
}
