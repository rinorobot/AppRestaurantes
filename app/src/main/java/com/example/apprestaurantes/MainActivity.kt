package com.example.apprestaurantes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apprestaurantes.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(),RestaurantViewHolder.OnRestaurantClinkListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RestaurantAdapter
    private val lista_restaurantes = ArrayList<Restaurante>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        searchByName()



    }

    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://demo2495997.mockable.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun initRecyclerView(){
        adapter = RestaurantAdapter(lista_restaurantes,this)
        binding.rvRestaurantes.layoutManager = LinearLayoutManager(this)
        binding.rvRestaurantes.adapter = adapter
    }

    private fun searchByName(){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getRestaurantes("restaurantes2")
            val restaurantes = call.body()
            runOnUiThread {
                if (call.isSuccessful){

                  val images = restaurantes?.lista_restaurantes ?: emptyList()

                    lista_restaurantes.clear()
                 lista_restaurantes.addAll(images)

                    adapter.notifyDataSetChanged()
                }else{
                    Toast.makeText(this@MainActivity,"Ha ocurrido un error"+call,Toast.LENGTH_LONG).show()
                }
            }
        }

    }

    override fun onItemClick(
        nombre: String,
        image: String,
        calif: String,
        anio: String,
        costo: String,
        id: String,
        resenia: String,
        foto1: String,
        foto2: String,
        foto3: String
    ) {
        val intent = Intent(this,DetalleRestaurante::class.java)
        intent.putExtra("nombre",nombre)
        intent.putExtra("image",image)
        intent.putExtra("calif",calif)
        intent.putExtra("anio",anio)
        intent.putExtra("costo",costo)
        intent.putExtra("id",id)
        intent.putExtra("resenia",resenia)
        intent.putExtra("foto1",foto1)
        intent.putExtra("foto2",foto2)
        intent.putExtra("foto3",foto3)
        startActivity(intent)
    }


}