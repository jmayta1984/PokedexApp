package pe.edu.upc.pokedex.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pe.edu.upc.pokedex.R
import pe.edu.upc.pokedex.data.model.Pokemon
import pe.edu.upc.pokedex.data.remote.ApiClient
import pe.edu.upc.pokedex.data.remote.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// Paso 1: Crear los layouts
// Paso 2: Colocar id a las vistas que necesitamos
// Paso 3: Declarar las vistas
// Paso 4: Inicializar las vistas


class MainActivity : AppCompatActivity() {

    lateinit var rvPokemon: RecyclerView
    lateinit var pokemons: ArrayList<Pokemon>
    lateinit var pokemonAdapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        loadItems()

    }

    private fun loadItems() {

        val pokemonInterface = ApiClient.build()

        val getPokemons = pokemonInterface?.getPokemons()

        getPokemons?.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful){
                    pokemons = response.body()!!.results
                    pokemonAdapter = PokemonAdapter(pokemons)
                    rvPokemon.adapter = pokemonAdapter
                    rvPokemon.layoutManager = LinearLayoutManager(this@MainActivity)

                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
            }
        })

    }

    private fun initViews() {
        rvPokemon = findViewById(R.id.rvPokemon)
    }
}