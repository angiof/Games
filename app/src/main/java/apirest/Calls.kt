package apirest

import ResGames
import retrofit2.Call
import retrofit2.http.GET

interface Calls {

    @GET("api/games")
    fun getGames(): Call<List<ResGames>>



}