package com.example.apprestaurantes

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.apprestaurantes.databinding.ActivityDetalleRestauranteBinding
import com.squareup.picasso.Picasso

class DetalleRestaurante : AppCompatActivity() {
    lateinit var binding: ActivityDetalleRestauranteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleRestauranteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.extras != null){
            binding.tvNombreDetalle.text = intent.getStringExtra("nombre").toString()
            binding.tvAnioDetalle.text = intent.getStringExtra("anio").toString()
            binding.tvCalifDetalle.text = intent.getStringExtra("calif").toString()
            binding.tvCostoDetalle.text = intent.getStringExtra("costo").toString()
            binding.tvReseniaDetalle.text = intent.getStringExtra("resenia").toString()



          Picasso.get().load(intent.getStringExtra("foto1")).into(binding.im1)
            Picasso.get().load(intent.getStringExtra("foto2")).into(binding.im2)
            Picasso.get().load(intent.getStringExtra("foto3")).into(binding.im3)

        }
    }
}