package com.example.catcalc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.TextView
import com.fathzer.soft.javaluator.DoubleEvaluator
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultTV.setMovementMethod(ScrollingMovementMethod())
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        var tv = v as TextView
        var resultTV = findViewById<TextView>(R.id.resultTV)
        var inputText = resultTV.text.toString()
        var newText = inputText

        when(tv.text.toString()){
            //NUMBERS
            "1" -> {
                PrintInput(inputText, newText, tv)
            }
            "2" -> {
                PrintInput(inputText, newText, tv)
            }
            "3" -> {
                PrintInput(inputText, newText, tv)
            }
            "4" -> {
                PrintInput(inputText, newText, tv)
            }
            "5" -> {
                PrintInput(inputText, newText, tv)
            }
            "6" -> {
                PrintInput(inputText, newText, tv)
            }
            "7" -> {
                PrintInput(inputText, newText, tv)
            }
            "8" -> {
                PrintInput(inputText, newText, tv)
            }
            "9" -> {
                PrintInput(inputText, newText, tv)
            }
            "0" -> {
                PrintInput(inputText, newText, tv)
            }
            "." -> {
                PrintInput(inputText, newText, tv)
            }

            //OPERATORS
            "+" -> {
                if(inputText.length > 0 && isPoint(newText[newText.length - 1]) == false && isOperator(newText[newText.length - 1]) == false){
                    PrintInput(inputText, newText, tv)
                }
            }
            "-" -> {
                if(inputText.length > 0 && isPoint(newText[newText.length - 1]) == false && isOperator(newText[newText.length - 1]) == false){
                    PrintInput(inputText, newText, tv)
                }
            }
            "*" -> {
                if(inputText.length > 0 && isPoint(newText[newText.length - 1]) == false && isOperator(newText[newText.length - 1]) == false){
                    PrintInput(inputText, newText, tv)
                }
            }
            "/" -> {
                if(inputText.length > 0 && isPoint(newText[newText.length - 1]) == false && isOperator(newText[newText.length - 1]) == false){
                    PrintInput(inputText, newText, tv)
                }
            }

            //BACK AND DELETE
            "◁" -> {
                if(inputText.length > 0){
                    newText = inputText.substring(0, inputText.length - 1)
                    resultTV.setText(newText)
                }
            }
            "C" -> {
                resultTV.setText(null)
            }

            //GET RESULTS
            "=" -> {
                if(resultTV.getText().trim().toString().length == 0){
                    Snackbar.make(resultTV, "Error: nothing to evaluate.", Snackbar.LENGTH_LONG).show()
                }
                else if(isPoint(newText[newText.length - 1]) == true && resultTV.getText().trim().toString().length == 1){
                    Snackbar.make(resultTV, "Error: more characters needed.", Snackbar.LENGTH_LONG).show()
                }
                else if(isOperator(newText[newText.length - 1]) == false && inputText.length > 0){
                    var evaluator = DoubleEvaluator()
                    var expression = resultTV.text.replace(Regex("×"), "*")
                    var result = evaluator.evaluate(expression)

                    resultTV.setText(result.toString())
                }
                else{
                    Snackbar.make(resultTV, "Error: last character can not be operator.", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }

    fun PrintInput (input: String, new: String, tv: TextView)  {
        var toAppendString = tv.text.toString()
        var input = input.substring(0, input.length)
        var new = input + toAppendString
        resultTV.setText(new)
    }

    fun isOperator(c: Char): Boolean {
        when(c){
            'x', '*', '/', '+', '-', '=' -> { return true}

            else -> return false
        }
    }

    fun isPoint(c: Char): Boolean {
        when(c){
            '.' -> {return true}

            else ->  return false
        }
    }

}