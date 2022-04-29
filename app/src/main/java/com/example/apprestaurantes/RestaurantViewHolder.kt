package com.example.apprestaurantes

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.apprestaurantes.databinding.ItemRestauranteBinding
import com.squareup.picasso.Picasso

class RestaurantViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemRestauranteBinding.bind(view)






    interface OnRestaurantClinkListener{
        fun onItemClick(nombre: String,image: String,calif: String,anio: String,costo: String,id:String, resenia: String,foto1:String,foto2:String,foto3:String)

    }



    fun bind(nombre: String,image: String,calif:String,anio: String,costo: String,id:String){
        Picasso.get().load(image).into(binding.ivRestaurante)
        binding.tvNombre.text = nombre
        binding.tvAnio.text = anio
        binding.tvCalif.text = calif
        binding.tvCosto.text = costo

    }

}