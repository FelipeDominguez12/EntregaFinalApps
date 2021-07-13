package CurpExam.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        generarCURP()
        limpiar()
    }


    /*~~~~~~~~~~~~~~~~~~~~~~~~Generar CURP~~~~~~~~~~~~~~~~~~~~~~~~*/
    private fun generarCURP(){
        var botonGenerar = findViewById<Button>(R.id.btnGenerar)
        botonGenerar.setOnClickListener{
            /*------------------------Variables------------------------*/
            // Se obtienen todos los datos que contiene
            // cada campo y se guarda en variables
            var txtNombre = findViewById<EditText>(R.id.txtNombre)
            var txtApePat = findViewById<EditText>(R.id.txtApellidoPat)
            var txtApeMat = findViewById<EditText>(R.id.txtApellidoMat)
            var txtdia = findViewById<EditText>(R.id.txtCampoDia)
            var txtmes = findViewById<EditText>(R.id.txtCampoMes)
            var txtaño = findViewById<EditText>(R.id.txtCampoAño)
            var txtgenero = findViewById<EditText>(R.id.txtCampoGenero)
            var txtestado = findViewById<EditText>(R.id.txtCampoEstado)
            var txtResultado = findViewById<TextView>(R.id.txtResultado)
            /*---------------------------------------------------------*/

            /*------------------------Conversiones------------------------*/
            var nombre = txtNombre.text.toString()
            var apePat = txtApePat.text.toString()
            var apeMat = txtApeMat.text.toString()
            var dia = txtdia.text.toString()
            var mes = txtmes.text.toString()
            var año = txtaño.text.toString()
            var genero = txtgenero.text.toString()
            var estado = txtestado.text.toString()
            /*------------------------------------------------------------*/


            /*------------------------Condiciones------------------------*/
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
                if (genero =="Mujer" || genero == "mujer"){
                    /*------------------------Condiciones de Estados------------------------*/

                    getEstadoSinApeMat()

                    /*----------------------------------------------------------------------*/

                } else if (genero == "Hombre" || genero == "hombre"){
                    /*------------------------Condiciones de Estados------------------------*/

                    getEstadoSinApeMat()

                    /*----------------------------------------------------------------------*/
                } else {
                    txtResultado.text = "Introducir Genero"
                }

            } else{
                if(genero == "Mujer" || genero == "mujer"){
                    /*------------------------Condiciones de Estados------------------------*/

                    getEstadoConApeMat()

                    /*----------------------------------------------------------------------*/

                } else if (genero == "Hombre" || genero == "hombre"){
                    /*------------------------Condiciones de Estados------------------------*/

                    getEstadoConApeMat()

                    /*----------------------------------------------------------------------*/

                } else if(genero == ""){
                    txtResultado.text = "Introducir Genero"
                } else {
                    txtResultado.text = "Favor de Especificar Hombre/Mujer"
                }
                ///////////////////////////////////////////////////
            }
        }
            /*-----------------------------------------------------------*/
        }
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    /*~~~~~~~~~~~~~~~~~~~~~~~~Limpiar Campos~~~~~~~~~~~~~~~~~~~~~~~~*/
    private fun limpiar(){
        var btnLimpiarDatos = findViewById<Button>(R.id.btnLimpiar)
        btnLimpiarDatos.setOnClickListener{
            var txtNombre = findViewById<EditText>(R.id.txtNombre)
            var txtApePat = findViewById<EditText>(R.id.txtApellidoPat)
            var txtApeMat = findViewById<EditText>(R.id.txtApellidoMat)
            var txtResultado = findViewById<TextView>(R.id.txtResultado)
            var txtdia = findViewById<EditText>(R.id.txtCampoDia)
            var txtmes = findViewById<EditText>(R.id.txtCampoMes)
            var txtaño = findViewById<EditText>(R.id.txtCampoAño)
            var txtgenero = findViewById<EditText>(R.id.txtCampoGenero)
            var txtestado = findViewById<EditText>(R.id.txtCampoEstado)

            txtNombre.setText("")
            txtApePat.setText("")
            txtApeMat.setText("")
            txtdia.setText("")
            txtmes.setText("")
            txtaño.setText("")
            txtgenero.setText("")
            txtestado.setText("")
            txtResultado.setText("")
        }
    }
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


    /*~~~~~~~~~~~~~~~~~~~~~~~~Letras Aleatorias~~~~~~~~~~~~~~~~~~~~~~~~*/
    private fun getChar(): String{
        var frases = arrayOf(
            "B","C","D","F","G","H","J",
            "K","L","M","Ñ","P","Q","R",
            "S","T","U","V","W","X","Y",
            "Z"
        )
        var randomfrase = (Math.random() * frases.size).toInt()
        return frases[randomfrase]
    }
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    /*private fun getCharDos(){
        var txtNombre = findViewById<EditText>(R.id.txtNombre)
        var txtApePat = findViewById<EditText>(R.id.txtApellidoPat)
        var txtApeMat = findViewById<EditText>(R.id.txtApellidoMat)

        var nombre = txtNombre.text.toString()
        var apePat = txtApePat.text.toString()
        var apeMat = txtApeMat.text.toString()

        var frases = arrayOf(
            "B","C","D","F","G","H","J",
            "K","L","M","Ñ","P","Q","R",
            "S","T","U","V","W","X","Y",
            "Z"
        )

        var cadena = "FELIPE DE JESUS"
        var letra = "F"

        var valor = cadena.indexOf(letra, 0)
        var consonante = cadena.charAt(valor)
        //var palabra = cadena.slice(0)

        //document.getElementById("palabra").innerHTML = consonante

    }*/

    /*~~~~~~~~~~~~~~~~~~~~~~~~Números Aleatorios~~~~~~~~~~~~~~~~~~~~~~~~*/
    private fun getNum(): String{
        var numeros = arrayOf(
            "0","1","2","3","4",
            "5","6","7","8","9"
        )
        var randomNum = (Math.random() * numeros.size).toInt()
        return numeros[randomNum]
    }
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    /*~~~~~~~~~~~~~~~~~~~~~~~~Condiciones de Estado~~~~~~~~~~~~~~~~~~~~~~~~*/
    private fun getEstadoSinApeMat(){

        /*------------------------Variables------------------------*/
        // Se obtienen todos los datos que contiene
        // cada campo y se guarda en variables
        var txtNombre = findViewById<EditText>(R.id.txtNombre)
        var txtApePat = findViewById<EditText>(R.id.txtApellidoPat)
        var txtdia = findViewById<EditText>(R.id.txtCampoDia)
        var txtmes = findViewById<EditText>(R.id.txtCampoMes)
        var txtaño = findViewById<EditText>(R.id.txtCampoAño)
        var txtgenero = findViewById<EditText>(R.id.txtCampoGenero)
        var txtestado = findViewById<EditText>(R.id.txtCampoEstado)
        var txtResultado = findViewById<TextView>(R.id.txtResultado)
        /*---------------------------------------------------------*/

        /*------------------------Conversiones------------------------*/
        var nombre = txtNombre.text.toString()
        var apePat = txtApePat.text.toString()
        var dia = txtdia.text.toString()
        var mes = txtmes.text.toString()
        var año = txtaño.text.toString()
        var genero = txtgenero.text.toString()
        var estado = txtestado.text.toString()
        /*------------------------------------------------------------*/


        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        if(estado == "Aguas Calientes" || estado == "aguas calientes"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "AS"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Baja California" || estado == "baja california"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "BC"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Baja California Sur" || estado == "baja california sur"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "BS"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Coahuila" || estado == "coahila"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "CL"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Chiapas" || estado == "chiapas"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "CS"+
                    //"${num}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Distrito Federal" || estado == "distrito federal"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "DF"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Guanajuato" || estado == "guanajuato"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "GT"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Hidalgo" || estado == "hidalgo"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "HG"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "México" || estado == "méxico"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "MC"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Morelos" || estado == "morelos"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "MS"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Nuevo León" || estado == "nuevo león"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "ML"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Puebla" || estado == "puebla"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "PL"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Quintana Roo" || estado == "quintana roo"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "QR"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Sinaloa" || estado == "sinaloa"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "SL"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Tabasco" || estado == "tabasco"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "TC"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Tlaxcala" || estado == "tlaxcala"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "TL"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Yucatan" || estado == "yucatan"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "YN"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Campeche" || estado == "campeche"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "CC"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Colima" || estado == "colima"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "CM"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Chihuahua" || estado == "chihuahua"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "CH"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Durango" || estado == "durango"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "DG"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Guerrero" || estado == "guerrero"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "GR"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Jalisco" || estado == "jalisco"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "JC"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Michoacán" || estado == "michoacán"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "MN"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Nayarit" || estado == "nayarit"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "NT"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Oaxaca" || estado == "oaxaca"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "OC"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Querétaro" || estado == "querétaro"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "QT"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "San Luis Potosí" || estado == "san luis potosí"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "SP"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Sonora" || estado == "sonora"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "SR"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Tamaulipas" || estado == "tamaulipas"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "TS"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Veracruz" || estado == "veracruz"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "VZ"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Zacatecas" || estado == "zacatecas"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "ZS"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Nacido en el Extranjero" || estado == "nacido en el extranjero"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+ "X"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "ZS"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else{
            txtResultado.text = "Especificar un Estado"
            if(estado == ""){
                txtResultado.text = "Introducir Estado"
            }

        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private fun getEstadoConApeMat(){

        /*------------------------Variables------------------------*/
        // Se obtienen todos los datos que contiene
        // cada campo y se guarda en variables
        var txtNombre = findViewById<EditText>(R.id.txtNombre)
        var txtApePat = findViewById<EditText>(R.id.txtApellidoPat)
        var txtApeMat = findViewById<EditText>(R.id.txtApellidoMat)
        var txtdia = findViewById<EditText>(R.id.txtCampoDia)
        var txtmes = findViewById<EditText>(R.id.txtCampoMes)
        var txtaño = findViewById<EditText>(R.id.txtCampoAño)
        var txtgenero = findViewById<EditText>(R.id.txtCampoGenero)
        var txtestado = findViewById<EditText>(R.id.txtCampoEstado)
        var txtResultado = findViewById<TextView>(R.id.txtResultado)
        /*---------------------------------------------------------*/

        /*------------------------Conversiones------------------------*/
        var nombre = txtNombre.text.toString()
        var apePat = txtApePat.text.toString()
        var apeMat = txtApeMat.text.toString()
        var dia = txtdia.text.toString()
        var mes = txtmes.text.toString()
        var año = txtaño.text.toString()
        var genero = txtgenero.text.toString()
        var estado = txtestado.text.toString()
        /*------------------------------------------------------------*/

        if(estado == "Aguas Calientes" || estado == "aguas calientes"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "AS"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Baja California" || estado == "baja california"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "BC"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Baja California Sur" || estado == "baja california sur"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "BS"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Coahuila" || estado == "coahuila"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "CL"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Chiapas" || estado == "chiapas"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "CS"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Distrito Federal" || estado == "distrito federal"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "DF"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Guanajuato" || estado == "guanajuato"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "GT"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Hidalgo" || estado == "hidalgo"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "HG"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "México" || estado == "méxico"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "MC"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Morelos" || estado == "morelos"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "MS"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Nuevo León" || estado == "nuevo león"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "ML"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Puebla" || estado == "puebla"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "PL"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Quintana Roo" || estado == "quintana roo"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "QR"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Sinaloa" || estado == "sinaloa"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "SL"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Tabasco" || estado == "tabasco"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "TC"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Tlaxcala" || estado == "tlaxcala"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "TL"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Yucatan" || estado == "yucatan"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "YN"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Campeche" || estado == "campeche"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "CC"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Colima" || estado == "colima"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "CM"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Chihuahua" || estado == "chihuahua"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "CH"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Durango" || estado == "durango"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "DG"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Guerrero" || estado == "guerrero"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "GR"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Jalisco" || estado == "jalisco"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "JC"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Michoacán" || estado == "michoacán"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "MN"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Nayarit" || estado == "nayarit"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "NT"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Oaxaca" || estado == "oaxaca"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "OC"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Querétaro" || estado == "querétaro"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "QT"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "San Luis Potosí" || estado == "san luis potosí"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "SP"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Sonora" || estado == "sonora"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "SR"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Tamaulipas" || estado == "tamaulipas"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "TS"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Veracruz" || estado == "veracruz"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "VZ"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Zacatecas" || estado == "zacatecas"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "ZS"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else if (estado == "Nacido en el Extranjero" || estado == "nacido en el extranjero"){
            txtResultado.text = "${apePat.toString().substring(0,2).toUpperCase()}"+
                    "${apeMat.toString().substring(0,1).toUpperCase()}"+
                    "${nombre.toString().substring(0,1).toUpperCase()}"+
                    "${año.toString().substring(2,4)}"+
                    "${mes.toString()}"+
                    "${dia.toString()}"+
                    "${genero.toString().substring(0,1).toUpperCase()}" + "NE"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getChar()}"+
                    "${getNum()}"+
                    "${getNum()}"
        } else{
            txtResultado.text = "Especificar un Estado"
            if(estado == ""){
                txtResultado.text = "Introducir Estado"
            }
        }
    }
}