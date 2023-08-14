package com.example.miproyectohubrido

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

//clase que permitira visualzar ambos metodos
class Pantalla1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pantalla1()
            EmpleadoHonorario()
        }
    }
}

//metodo con su estilo que permitira ingresar datos
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun EmpleadoHonorario(){
    var sueldoBruto by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    Column {
        Text("Sueldo a Honorarios")
        TextField(
            value = sueldoBruto,
            onValueChange = { sueldoBruto = it},
            label = { Text ("Sueldo Bruto")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
//boton que permitira hacer el calculo mostrando su mensaje y resultado
        Button(onClick = {
            val montoBruto = sueldoBruto.toIntOrNull() ?: 0
            val liquido = calcularLiquido(montoBruto)
            resultado = "El monto liquido a pagar es: " + liquido

        }) {
            Text ("Calcular")
        }
        Text (resultado)
    }

}
//funcion que realiza proceso logico de restar 13% al sueldo bruto ingresado
fun calcularLiquido(sueldoBruto: Int): Int {
    return sueldoBruto - (sueldoBruto * 0.13).toInt()
}

//funcion de volver atras mediante boton
@Preview(showBackground = true)
@Composable
fun Pantalla1() {
    val contexto = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
            verticalArrangement = Arrangement.Bottom
    ) {
        Button(onClick = {
            val intent = Intent(contexto, MainActivity::class.java)
            contexto.startActivity( intent )
        }) {
            Text(text = "<- Volver")
        }
    }

}