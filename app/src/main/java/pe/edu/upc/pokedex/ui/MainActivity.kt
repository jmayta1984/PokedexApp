package pe.edu.upc.pokedex.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pe.edu.upc.pokedex.R
import pe.edu.upc.pokedex.data.model.Pokemon

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
        setAdapter()
    }

    private fun setAdapter() {
        pokemonAdapter = PokemonAdapter(pokemons)
        rvPokemon.adapter = pokemonAdapter

        rvPokemon.layoutManager = LinearLayoutManager(this)
    }

    private fun loadItems() {
        pokemons = ArrayList()
    }

    private fun initViews() {
        rvPokemon = findViewById(R.id.rvPokemon)
    }
}