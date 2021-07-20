package com.example.projetobootcamp.di

import com.example.projetobootcamp.repository.MainRepository
import com.example.projetobootcamp.ui.detalhesJogo.DetalhesJogoViewModel
import com.example.projetobootcamp.ui.listaJogos.ListaJogosViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    factory {
        MainRepository()
    }

    viewModel {
        ListaJogosViewModel(
            repository = get()
        )
    }
    viewModel {
        DetalhesJogoViewModel(
            repository = get()
        )
    }
}