package com.example.projetobootcamp.service

import com.example.projetobootcamp.model.JogoItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface API {
    @GET("api/games")
    suspend fun getJogos(): Response<MutableList<JogoItem>>

    @GET("api/game{id}")
    suspend fun getDetalhes(@Path("id")id: Int): Response<JogoItem>
}