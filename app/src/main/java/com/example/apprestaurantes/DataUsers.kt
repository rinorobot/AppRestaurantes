package com.example.apprestaurantes

import com.google.gson.annotations.SerializedName

data class DataUsers(@SerializedName("status") var status: String, @SerializedName("message") var lista_usuarios: List<Usuario>)
