package com.example.games.views.progetto.viewmodles

import ResGames
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import apirest.ClientRetro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelGames(application: Application) : AndroidViewModel(application) {

    var lista = MutableLiveData<List<ResGames>>()

    init {
        getGamesFromViewModel()

    }

    private fun getGamesFromViewModel() {

        ClientRetro.instance?.createService()?.getGames()
            ?.enqueue(object : Callback<List<ResGames>> {
                override fun onResponse(
                    call: Call<List<ResGames>>,
                    response: Response<List<ResGames>>
                ) {

                    lista.value = response.body()

                }

                override fun onFailure(call: Call<List<ResGames>>, t: Throwable) {
                   //qui i commenti non servono
                    Log.d("tag ramo2","tag ramo2")
                    //questo è il secondo ramo con i commenti questi commenti
                    //devono viaggiare verso il secondo branch
                    Log.d("tag2 ramo2","tag ramo2")



                }

            })

    }


}

