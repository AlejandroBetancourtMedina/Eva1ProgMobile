package com.example.miproyectohubrido

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        PantallaInicio()
        }
    }
}
@Preview
@Composable
fun PantallaInicio(){
    val contexto = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(
            text = "Bienvenido!",
            fontSize = 24.sp, // Tamaño de fuente más grande
            modifier = Modifier.padding(bottom = 8.dp) // Espacio inferior
        )
        Text(
            text = "Selecciona tipo de Pago...",
            fontSize = 18.sp, // Tamaño de fuente para el mensaje
            modifier = Modifier.padding(bottom = 24.dp) // Espacio inferior
        )

        Button(onClick = {
            val intent = Intent(contexto, Pantalla1Activity::class.java)
            contexto.startActivity( intent )
        }){
        Text(text = "Honorarios")
    }
    Spacer(modifier = Modifier.height(20.dp))
    Button(onClick = {
        val intent = Intent(contexto, Pantalla2Activity::class.java)
        contexto.startActivity( intent )

    }) {
        Text("Contratado")
       }
    }
}