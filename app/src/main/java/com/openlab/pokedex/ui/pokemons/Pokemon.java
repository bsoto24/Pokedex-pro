package com.openlab.pokedex.ui.pokemons;

import com.openlab.pokedex.data.entity.PokemonTO;

import java.util.List;

/**
 * Created by Bryam Soto on 27/02/2018.
 */

public interface Pokemon {

    interface Model {

        void getPokemons(int offset);

    }

    interface View {

        void showPokemons(List<PokemonTO> pokemons);

        void showError(String error);

    }

    interface Presenter {

        void getPokemons(int offset);

        void showPokemons(List<PokemonTO> pokemons);

        void showError(String error);

    }
}
