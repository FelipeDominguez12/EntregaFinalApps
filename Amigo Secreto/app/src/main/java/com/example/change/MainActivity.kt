package com.example.change

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        datosArreglo();
    }
    private fun datosArreglo(){
        val miArreglo = ArrayList<String>()
        miArreglo.add("Elemento 0")
        miArreglo.add("Elemento 1")
        miArreglo.add("Elemento 2")

    }
}