package com.example.projetobootcamp.ui.detalhesJogo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.projetobootcamp.R
import kotlinx.android.synthetic.main.detalhes_jogo.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetalhesJogoFragment : Fragment() {

    private val detalhesViewModel: DetalhesJogoViewModel by viewModel()
    private val argumentos by navArgs<DetalhesJogoFragmentArgs>()
    private val jogo by lazy { argumentos.jogo }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.detalhes_jogo,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("RESPONSE", "onViewCreated: chegou para ir ao configDetalhes ")
        configDetalhes()
    }

    private fun configDetalhes() {
        detalhesViewModel.getDetalhes(jogo.id)
        detalhesViewModel.fResponse.observe(viewLifecycleOwner, {
                tv_titulo_jogo_detalhes.text = jogo.title
                tv_genero_jogo_detalhes.text = jogo.genre
                tv_plataforma_jogo_detalhes.text = jogo.platform
                tv_desenvolvedor_jogo_detalhes.text = jogo.developer
            Glide.with(requireContext())
                .load(jogo.thumbnail)
                .transform(CenterCrop())
                .into(iv_jogo_detalhes)
        })
    }
}