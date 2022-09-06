package pe.edu.upc.pokedex.data.remote

import retrofit2.Call
import retrofit2.http.GET

interface PokemonInterface {

    @GET("pokemon")
    fun getPokemons(): Call<ApiResponse>
}