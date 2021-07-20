package com.example.projetobootcamp.repository

import com.example.projetobootcamp.model.JogoItem
import com.example.projetobootcamp.service.API
import com.example.projetobootcamp.service.AppRetrofit
import retrofit2.Response

class MainRepository(
    private val api: API = AppRetrofit().jogosService
) {

    suspend fun getJogos(): Response<MutableList<JogoItem>>{
        return api.getJogos()
    }

    suspend fun getDetalhes(id: Int): Response<JogoItem>{
        return api.getDetalhes(id)
    }

}
