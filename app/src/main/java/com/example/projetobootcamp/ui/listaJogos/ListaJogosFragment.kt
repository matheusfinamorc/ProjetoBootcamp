package com.example.projetobootcamp.ui.listaJogos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.VERTICAL
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetobootcamp.R
import com.example.projetobootcamp.adapter.ListaJogosAdapter
import com.example.projetobootcamp.model.JogoItem
import kotlinx.android.synthetic.main.lista_jogos.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListaJogosFragment() : Fragment() {

    private val listaJogosViewModel: ListaJogosViewModel by viewModel()

    private val adapter by lazy {
        context?.let {
            ListaJogosAdapter(context = it)
        }
    }
    private val controlador by lazy {
        findNavController()
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configuraRecyclerView()
        configuraLista()
    }


    private fun getJogos() {
        listaJogosViewModel.getJogos()
        listaJogosViewModel.mResponse.observe(this, { resposta ->
            if (resposta.isSuccessful) {
                resposta.body()?.let { jogos ->
                    adapter?.add(jogos)
                }
            } else {
                Log.i("Response", resposta.errorBody().toString())
            }
        })
    }

    private fun configuraLista() {
        adapter?.onItemClickListener = {
            goToDetalhes(it)
        }

        lista_jogos_recyclerView.adapter = adapter
        lista_jogos_recyclerView.layoutManager = LinearLayoutManager(context)

    }

    private fun goToDetalhes(jogo: JogoItem) {
        val direcao = ListaJogosFragmentDirections
            .actionListaJogosToDetalhesJogo(jogo)
        controlador.navigate(direcao)

    }

    private fun configuraRecyclerView() {
        val divisor = DividerItemDecoration(context, VERTICAL)
        lista_jogos_recyclerView.addItemDecoration(divisor)
        lista_jogos_recyclerView.adapter = adapter
    }
}