package com.example.projetobootcamp.ui.listaJogos

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetobootcamp.model.JogoItem
import com.example.projetobootcamp.repository.MainRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class ListaJogosViewModel(
    private val repository: MainRepository
    ): ViewModel() {
    val mResponse: MutableLiveData<Response<MutableList<JogoItem>>> = MutableLiveData()

        fun getJogos(){
            viewModelScope.launch {
                val response = repository.getJogos()
                mResponse.value = response
            }
        }

}
