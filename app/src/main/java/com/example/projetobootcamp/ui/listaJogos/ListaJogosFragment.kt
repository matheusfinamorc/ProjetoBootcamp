package com.example.projetobootcamp.ui.listaJogos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetobootcamp.R
import com.example.projetobootcamp.adapter.ListaJogosAdapter
import kotlinx.android.synthetic.main.lista_jogos.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListaJogosFragment() : Fragment() {

    private val listaJogosViewModel: ListaJogosViewModel by viewModel()

    private val adapter by lazy {
        context?.let {
            ListaJogosAdapter(context = it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configuraRecyclerView()
        configuraLista()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         getJogos()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.lista_jogos,
            container,
            false
        )
    }


    private fun getJogos() {
        listaJogosViewModel.getJogos()
        listaJogosViewModel.mResponse.observe(this, { resposta ->
            if (resposta.isSuccessful) {
                resposta.body()?.let { jogos ->
                    adapter?.add(jogos)
                    Log.i("Response", jogos[1].title)
                }
            } else {
                Log.i("Response", resposta.errorBody().toString())
            }
        })
    }

    private fun configuraLista() {
        lista_jogos_recyclerView.adapter = adapter
        lista_jogos_recyclerView.layoutManager = LinearLayoutManager(context)

    }

    private fun configuraRecyclerView() {
        val divisor = DividerItemDecoration(context, LinearLayout.VERTICAL)
        lista_jogos_recyclerView.addItemDecoration(divisor)
        lista_jogos_recyclerView.adapter = adapter
    }
}