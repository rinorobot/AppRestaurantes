package com.example.apprestaurantes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val saltar = findViewById<TextView>(R.id.tvSaltarRegistro)
        val nombre = findViewById<TextView>(R.id.etNombreRegistro)
        val apellido = findViewById<TextView>(R.id.etApellidoRegistro)
        val usuario = findViewById<TextView>(R.id.etUsuarioRegistro)
        val password = findViewById<TextView>(R.id.etContaseniaRegistro)

        saltar.setOnClickListener {


            if(nombre.text.toString().equals("")){
                nombre.setError("Escribre algo.")
            } else if (apellido.text.toString().equals("")){
                apellido.setError("Escribre algo.")
            }else if (usuario.text.toString().equals("")){
                usuario.setError("Escribre algo.")
            }else if (password.text.toString().equals("")){
                password.setError("Escribre algo.")
            }else{
                Toast.makeText(this,"Registro exitoso",Toast.LENGTH_LONG).show()
                val intent = Intent(this,Login::class.java)
                startActivity(intent)
                finish()
            }

        }
    }
}