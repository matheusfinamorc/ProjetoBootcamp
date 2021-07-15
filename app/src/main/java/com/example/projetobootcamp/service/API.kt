package com.example.projetobootcamp.service

import com.example.projetobootcamp.model.JogoItem
import retrofit2.Response
import retrofit2.http.GET

interface API {
    @GET("api/games")
    suspend fun getJogos(): Response<MutableList<JogoItem>>
}