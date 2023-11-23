package com.primatestech.practica1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var conversion:Int=0
    private var value: String = ""
    private var endResult : Double = 0.0
    private  lateinit var total : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var temperatura = findViewById<EditText>(R.id.temperature)
        val botton = findViewById<Button>(R.id.action)
        val spinner = findViewById<Spinner>(R.id.spinner)
        total = findViewById(R.id.result)
        val options = resources.getStringArray(R.array.convert_options)


        if (spinner != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
            spinner.adapter = adapter
            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    conversion = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

        }
        botton.setOnClickListener {

            value = temperatura.text.toString()
            converter(conversion)
        }
    }
       fun converter(convert:Int){
           when(convert){
               0 ->{
                   //°Cto°F
                   value.toDouble()
                   endResult = ((value.toDouble() * 9/5) + 32)
                   total.text = endResult.toString()
               }
               1 ->{
                   //°Cto°K
                   value.toDouble()
                   endResult = ((value.toDouble() + 273.15))
                   total.text = endResult.toString()
               }

               2 ->{
                   //°Fto°C
                   endResult = ((value.toDouble() -32) * 5/9)
                   total.text = endResult.toString()
               }
               3 ->{
                    //°Fto°K
                   value.toDouble()
                   endResult = ((value.toDouble() -32) * 5/9 + 273.15)
                   total.text = endResult.toString()
               }
               4 ->{
                   //°Kto°C
                   value.toDouble()
                   endResult = (value.toDouble() -273.15)
                   total.text = endResult.toString()
               }
               5 ->{
                   //°Kto°F

                   value.toDouble()
                   endResult = (value.toDouble() -273.15) * 9/5 +32
                   total.text = endResult.toString()
               }
           }

       }
    }