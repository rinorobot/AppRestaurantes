package com.example.apprestaurantes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Login : AppCompatActivity() {
    private val lista_usuarios = ArrayList<Usuario>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        searchByName()


        val username = findViewById<EditText>(R.id.etUsuarioLogin)
        val password = findViewById<EditText>(R.id.etContraseniaLogin)
        val login = findViewById<Button>(R.id.btnLogin)

        login.setOnClickListener {


            if (username.text.toString().equals("")){
                username.setError("Escribre algo")
            }else if (password.text.toString().equals("")){
                password.setError("Escribre algo")
            }else{

                val user_name = username.text.toString()
                val pass = password.text.toString()







                for (i in 0..lista_usuarios.size-1){
                    if(user_name.equals(lista_usuarios[i].username)&&pass.equals(lista_usuarios[i].password)){
                        Toast.makeText(this@Login,"Login exitoso", Toast.LENGTH_LONG).show()
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                        finish()
                        return@setOnClickListener



                    }

                }

                Toast.makeText(this@Login,"Usuario o contraseña incorrectos, vuelve a intentarlo", Toast.LENGTH_LONG).show()


            }




        }


    }



    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://demo2495997.mockable.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchByName(){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getUsuarios("lectura_usuarios")
            val usuarios = call.body()
            runOnUiThread {
                if (call.isSuccessful){

                    val users = usuarios?.lista_usuarios ?: emptyList()

                    lista_usuarios.addAll(users)



                }else{
                    Toast.makeText(this@Login,"Ha ocurrido un error"+call, Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}