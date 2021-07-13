package com.example.rfc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.security.PrivateKey
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        generarRFC()
        limpiar()
    }

    private fun generarRFC() {
        var botonGenerar = findViewById<Button>(R.id.btnGenerar)
        botonGenerar.setOnClickListener{
            var txtNombre = findViewById<EditText>(R.id.Name)
            var txtApePat = findViewById<EditText>(R.id.apePat)
            var txtApeMat = findViewById<EditText>(R.id.apeMat)
            var txtdia = findViewById<EditText>(R.id.txtDia)
            var txtmes = findViewById<EditText>(R.id.txtMes)
            var txtaño = findViewById<EditText>(R.id.txtAño)
            var txtResultado = findViewById<TextView>(R.id.Resultadorfc)

            /*Expresiones Regulares*/
            var letra = "^{A-Z}{2}{A-Z}{1}{A-Z}{1}{0-9}{2}{0-9}{2}{0-9}{2}{0-9}{3}$"
            var numeros = "^{A-Z}{2}{A-Z}{1}{A-Z}{1}{0-9}{2}{0-9}{2}{0-9}{2}{A-Z}{3}$"

            //var aleatorioUno = Random
            //var num = aleatorioUno.nextInt(100,999)

            var nombre = txtNombre.text.toString()
            var apePat = txtApePat.text.toString()
            var apeMat = txtApeMat.text.toString()
            var dia = txtdia.text.toString()
            var mes = txtmes.text.toString()
            var año = txtaño.text.toString()

            /*Condiciones*/
            if (apePat==""){
                txtResultado.text = "Introducir Apellido Paterno"
            } else if(nombre==""){
                txtResultado.text = "Introducir Nombre"
            } else if(dia==""){
                txtResultado.text = "Introducir Dia"
            } else if(mes==""){
                txtResultado.text = "Introducir Mes"
            } else if(año==""){
                txtResultado.text = "Introducir Año"
            } else if(apeMat==""){
                txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                        "${nombre.toString().substring(0,1).toUpperCase()}"+
                        "${año.toString().substring(2,4)}"+
                        "${mes.toString()}"+
                        "${dia.toString()}"+
                        //"${num}"+
                        "${getChar()}"+
                        "${getChar()}"+
                        "${getChar()}"
            } else{
                txtResultado.text = "${
                    apePat.toString().substring(0,2).toUpperCase()}"+
                        "${apeMat.toString().substring(0,1).toUpperCase()}"+
                        "${nombre.toString().substring(0,1).toUpperCase()}"+
                        "${año.toString().substring(2,4)}"+
                        "${mes.toString()}"+
                        "${dia.toString()}"+
                        "${getChar()}"+
                        "${getChar()}"+
                        "${getChar()}"
            }
        }

    }

    private fun limpiar(){
        var btnLimpiarDatos = findViewById<Button>(R.id.btnLimpiar)
        btnLimpiarDatos.setOnClickListener{
            var txtNombre = findViewById<EditText>(R.id.Name)
            var txtApePat = findViewById<EditText>(R.id.apePat)
            var txtApeMat = findViewById<EditText>(R.id.apeMat)
            var txtResultado = findViewById<TextView>(R.id.Resultadorfc)
            var txtdia = findViewById<EditText>(R.id.txtDia)
            var txtmes = findViewById<EditText>(R.id.txtMes)
            var txtaño = findViewById<EditText>(R.id.txtAño)

            txtNombre.setText("")
            txtApePat.setText("")
            txtApeMat.setText("")
            txtdia.setText("")
            txtmes.setText("")
            txtaño.setText("")
            txtResultado.setText("")

        }
    }

    /*Generar homoclave*/
    private fun getChar(): String{
        var frases = arrayOf(
                "A","B","C","D","E","F","G","H","I",
                "J","K","L","M","Ñ","O","P","Q","R",
                "S","T","U","V","W","X","Y","Z","0",
                "1","2","3","4","5","6","7","8","9"
        )
        var randomfrase = (Math.random() * frases.size).toInt()
        return frases[randomfrase]
    }
}