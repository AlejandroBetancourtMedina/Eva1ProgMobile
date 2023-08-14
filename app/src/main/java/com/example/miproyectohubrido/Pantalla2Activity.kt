package com.example.miproyectohubrido

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Pantalla2Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla2)


        val etBruto = findViewById<EditText>(R.id.sueldoBrutoEditText)
        val btn = findViewById<Button>(R.id.btnCalcular)
        val etResultado = findViewById<TextView>(R.id.resultadoTextView)

        btn.setOnClickListener{
            val sueldoBruto = etBruto.text.toString().toIntOrNull() ?:0
            val liquido = calcularLiquido(sueldoBruto)
            etResultado.text = "El sueldo a pagar es ${liquido}"

        }

        fun calcularLiquido(sueldoBruto:Int):Int{
            return sueldoBruto - (sueldoBruto * 0.20).toInt()
        }


        val btnVolver = findViewById<Button>(R.id.btnVolver)
        btnVolver.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity( intent )
        }
    }
}
