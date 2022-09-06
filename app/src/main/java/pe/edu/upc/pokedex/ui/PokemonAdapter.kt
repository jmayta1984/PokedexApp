package pe.edu.upc.pokedex.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.edu.upc.pokedex.R
import pe.edu.upc.pokedex.data.model.Pokemon

class PokemonAdapter(val pokemons: ArrayList<Pokemon>) : RecyclerView.Adapter<PokemonPrototype>() {
    // Vista de cada fila
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonPrototype {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.prototype_pokemon, parent, false)
        return PokemonPrototype(view)
    }

    // Muestra los datos por cada fila
    override fun onBindViewHolder(pokemonPrototype: PokemonPrototype, position: Int) {
        pokemonPrototype.bindTo(pokemons[position], position)
    }

    // Cantidad de elementos a mostrar
    override fun getItemCount(): Int {
        return pokemons.size
    }
}

class PokemonPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    lateinit var ivPokemon: ImageView
    lateinit var tvName: TextView

    fun bindTo(pokemon: Pokemon, position: Int) {
        ivPokemon = itemView.findViewById(R.id.ivPokemon)
        tvName = itemView.findViewById(R.id.tvName)

        tvName.text = pokemon.name

        Glide.with(itemView)
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+(position+1)+".png")
            .into(ivPokemon)
    }

}
