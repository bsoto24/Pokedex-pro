package com.openlab.pokedex.ui.pokemons;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openlab.pokedex.R;
import com.openlab.pokedex.data.entity.PokemonTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bryam Soto on 27/02/2018.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {

    private Context context;
    private List<PokemonTO> pokemonTOS;

    PokemonAdapter(Context context) {
        this.pokemonTOS = new ArrayList<>();
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_pokemon, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(pokemonTOS.get(position));
    }

    @Override
    public int getItemCount() {
        return pokemonTOS.size();
    }

    public void addPokemons(List<PokemonTO> pokemonTOS) {
        this.pokemonTOS.addAll(pokemonTOS);
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgPokemon;
        private TextView tvPokemon;

        ViewHolder(View itemView) {
            super(itemView);

            imgPokemon = itemView.findViewById(R.id.imgPokemon);
            tvPokemon = itemView.findViewById(R.id.tv_pokemon);
        }

        void bind(PokemonTO pokemonTO) {

            String[] urlPartes = pokemonTO.getUrl().split("/");
            String imageUrl = "http://pokeapi.co/media/sprites/pokemon/" + Integer.parseInt(urlPartes[urlPartes.length - 1]) + ".png";
            Log.e("IMAGEN: ", imageUrl);
            tvPokemon.setText(pokemonTO.getName());
            Glide.with(context)
                    .load(imageUrl)
                    .into(imgPokemon);

        }

    }
}
