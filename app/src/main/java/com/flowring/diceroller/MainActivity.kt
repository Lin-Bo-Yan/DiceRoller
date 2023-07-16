package com.flowring.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll)
        rollButton.setOnClickListener{
            //呼叫Toast.makeText()即可建立內涵文字"Dice Rolled!"的Toast
            Toast.makeText(this,"Dice Rolled!",Toast.LENGTH_LONG).show()
            rollDice()//執行滾動功能
        }

    }

    private fun rollDice(){
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextView:TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()

        val luckyTextView:TextView = findViewById(R.id.textView2)
        val luckyNumber = 6
        if(luckyNumber == diceRoll){
            resultTextView.text = "Lucky Number"
        } else {
            resultTextView.text = ""
        }

        val imageView: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.one
            2 -> R.drawable.two
            3 -> R.drawable.three
            4 -> R.drawable.four
            5 -> R.drawable.five
            else -> R.drawable.six
        }
        imageView.setImageResource(drawableResource)

    }
}