package pe.edu.upc.pokedex.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {
        private const val API_BASE_URL  = "https://pokeapi.co/api/v2/pokemon/"
    }
    private var pokemonInterface: PokemonInterface? = null

    fun build(): PokemonInterface? {
        var builder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        var retrofit: Retrofit = builder.build()

        pokemonInterface = retrofit.create(PokemonInterface::class.java)

        return pokemonInterface as PokemonInterface
    }


}