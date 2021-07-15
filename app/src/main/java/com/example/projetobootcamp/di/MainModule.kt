package com.example.projetobootcamp.di

import com.example.projetobootcamp.repository.ListaRepository
import com.example.projetobootcamp.ui.listaJogos.ListaJogosViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    factory {
        ListaRepository()
    }

    viewModel {
        ListaJogosViewModel(
            repository = get()
        )
    }
}