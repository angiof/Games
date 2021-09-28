package com.example.games.views.progetto.frags

import ResGames
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ActivityNavigator
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorDestinationBuilder
import androidx.recyclerview.widget.GridLayoutManager
import com.example.games.databinding.FragmentFragListaGamesHosterBinding
import com.example.games.views.progetto.adapters.AdapterTopGAmes
import com.example.games.views.progetto.viewmodles.ViewModelGames


class FragListaGamesHoster : Fragment() {
    lateinit var
            binding: FragmentFragListaGamesHosterBinding
    lateinit var
            adapterTopGAmes: AdapterTopGAmes
    lateinit var
            viewModelGames: ViewModelGames

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModelGames = ViewModelProvider(requireActivity()).get(ViewModelGames::class.java)



        binding = FragmentFragListaGamesHosterBinding.inflate(layoutInflater)

        with(binding.listarecy) {
            adapterTopGAmes = AdapterTopGAmes(requireContext() ,object : AdapterTopGAmes.OnTapItemView {
                override fun sendToDestination(entityConfig: ResGames) {


                    val action =FragListaGamesHosterDirections.actionFragListaGamesHosterToFragHosterGamesOnTap(

                        entityConfig.title,
                        entityConfig.short_description

                    )


                    requireView().findNavController().navigate(action)

                }

            })
            layoutManager = GridLayoutManager(requireContext(), 2)

            setHasFixedSize(true)
            viewModelGames.lista.observe(viewLifecycleOwner, {
                adapterTopGAmes.submitList(it)
            })
            adapter = adapterTopGAmes


        }


        return binding.root

    }

}