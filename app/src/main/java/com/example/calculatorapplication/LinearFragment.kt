package com.example.calculatorapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder


class LinearFragment : Fragment(R.layout.fragment_linear) {

    private var expression = ""
    private lateinit var view: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.view = view

        view.findViewById<Button>(R.id.button0)

        view.findViewById<Button>(R.id.button0).setOnClickListener { appendValue("0") }
        view.findViewById<Button>(R.id.button1).setOnClickListener { appendValue("1") }
        view.findViewById<Button>(R.id.button2).setOnClickListener { appendValue("2") }
        view.findViewById<Button>(R.id.button3).setOnClickListener { appendValue("3") }
        view.findViewById<Button>(R.id.button4).setOnClickListener { appendValue("4") }
        view.findViewById<Button>(R.id.button5).setOnClickListener { appendValue("5") }
        view.findViewById<Button>(R.id.button6).setOnClickListener { appendValue("6") }
        view.findViewById<Button>(R.id.button7).setOnClickListener { appendValue("7") }
        view.findViewById<Button>(R.id.button8).setOnClickListener { appendValue("8") }
        view.findViewById<Button>(R.id.button9).setOnClickListener { appendValue("9") }
        view.findViewById<Button>(R.id.buttonDot).setOnClickListener { appendValue(".") }
        view.findViewById<Button>(R.id.buttonClear).setOnClickListener { clear() }
        view.findViewById<Button>(R.id.buttonDelete).setOnClickListener { delete() }
        view.findViewById<Button>(R.id.buttonPlus).setOnClickListener { operatorClicked("+") }
        view.findViewById<Button>(R.id.buttonMinus).setOnClickListener { operatorClicked("-") }
        view.findViewById<Button>(R.id.buttonMultiply).setOnClickListener { operatorClicked("*") }
        view.findViewById<Button>(R.id.buttonDivide).setOnClickListener { operatorClicked("/") }
        view.findViewById<Button>(R.id.buttonEquals).setOnClickListener { evaluate() }
    }

    private fun appendValue(value: String) {
        expression += value
        view.findViewById<TextView>(R.id.resultTextView).text = expression
    }

    private fun clear() {
        expression = ""
        view.findViewById<TextView>(R.id.resultTextView).text = expression
    }

    private fun delete() {
        if (expression.isNotEmpty()) {
            expression = expression.substring(0, expression.length - 1)
            view.findViewById<TextView>(R.id.resultTextView).text = expression
        }
    }

    private fun operatorClicked(operator: String) {
        if (expression.isNotEmpty() && expression.last().isDigit()) {
            expression += operator
            view.findViewById<TextView>(R.id.resultTextView).text = expression
        }
    }

    private fun evaluate() {
        if (expression.isNotEmpty() && expression.last().isDigit()) {
            val result = ExpressionBuilder(expression).build().evaluate()
            expression = result.toString()
            view.findViewById<TextView>(R.id.resultTextView).text = expression
        }
    }

    companion object{
        const val TAG = "LinearFragment"
    }
}