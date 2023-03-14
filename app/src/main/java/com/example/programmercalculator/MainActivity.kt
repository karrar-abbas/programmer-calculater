package com.example.programmercalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.ButtonBarLayout

class MainActivity : AppCompatActivity() {
    lateinit var spinner: Spinner
    lateinit var spinner2: Spinner
    lateinit var values:TextView
    lateinit var result:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initview()
        initSpinner()
    }
    private fun initview(){
        values=findViewById(R.id.firstNum)
    }
    fun clear(v:View){
       values.text=""
    }
    fun res(v:View){

        val decimal = Integer.valueOf(values.text.toString(),16)
        result.text=decimal.toString()
    }
    private fun initSpinner(){
        spinner= findViewById(R.id.spinner)
        spinner2= findViewById(R.id.spinner2)

        ArrayAdapter.createFromResource(
            this,
            R.array.systems,
            android.R.layout.simple_spinner_item
        ).also { adapter ->

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinner.adapter = adapter
        }
        ArrayAdapter.createFromResource(
            this,
            R.array.systems,
            android.R.layout.simple_spinner_item
        ).also { adapter ->

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinner2.adapter = adapter
        }
    }
    fun onClickButton(v:View){
        val newEnter=(v as Button).text.toString()
        val oldEnter=values.text.toString()
        val newAdd=oldEnter+newEnter
        values.text=newAdd
    }
}
