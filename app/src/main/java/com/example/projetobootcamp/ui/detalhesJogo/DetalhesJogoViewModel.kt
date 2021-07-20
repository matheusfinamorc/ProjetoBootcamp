package com.example.projetobootcamp.ui.detalhesJogo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetobootcamp.model.JogoItem
import com.example.projetobootcamp.repository.MainRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class DetalhesJogoViewModel(
    private val repository: MainRepository
) : ViewModel() {
   // val mResponse: MutableLiveData<Response<MutableList<JogoItem>>> = MutableLiveData()
    val fResponse: MutableLiveData<Response<JogoItem>> = MutableLiveData()

    fun getDetalhes(id: Int){
        viewModelScope.launch {
            val response = repository.getDetalhes(id)
            fResponse.value = response
        }
    }

}
