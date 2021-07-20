package com.example.projetobootcamp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetobootcamp.R
import com.example.projetobootcamp.model.JogoItem
import kotlinx.android.synthetic.main.item_jogo.view.*

class ListaJogosAdapter(
    private val context: Context,
    private var jogos: MutableList<JogoItem> = mutableListOf(),
    var onItemClickListener: (jogo: JogoItem) -> Unit = {}
) : RecyclerView.Adapter<ListaJogosAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListaJogosAdapter.ViewHolder {
        val viewCriada = LayoutInflater.from(context).inflate(
            R.layout.item_jogo,
            parent,
            false
        )
        return ViewHolder(viewCriada)
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.vincula(jogos[position])
    }

    override fun getItemCount() = jogos.size

    fun add(jogos: List<JogoItem>) {
        this.jogos.clear()
        this.jogos.addAll(jogos)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private lateinit var jogo: JogoItem
        private val campoNome by lazy { itemView.item_nome_jogo }
        private val campoGenero by lazy { itemView.item_genero_jogo }

        init {
            itemView.setOnClickListener {
                if (::jogo.isInitialized){
                    onItemClickListener(jogo)
                }
            }
        }

        fun vincula(jogoItem: JogoItem) {
            this.jogo = jogoItem
            campoNome.text = jogo.title
            campoGenero.text = jogo.genre
        }
    }

}
