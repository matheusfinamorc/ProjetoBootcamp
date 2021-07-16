package com.example.projetobootcamp.model

import java.io.Serializable


data class JogoItem(
    var id: Int,
    val title: String,
    val genre: String,
    val platform: String,
    val developer: String,
    val release_date: String
): Serializable
