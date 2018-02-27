package com.openlab.pokedex.ui.pokemons;

import com.openlab.pokedex.data.entity.PokemonTO;

import java.util.List;

/**
 * Created by Bryam Soto on 27/02/2018.
 */

public class PokemonPresenter implements Pokemon.Presenter {

    private Pokemon.Model model;
    private Pokemon.View view;

    PokemonPresenter(Pokemon.View view) {
        this.view = view;
        model = new PokemonModel(this);
    }

    @Override
    public void getPokemons(int offset) {
        model.getPokemons(offset);
    }

    @Override
    public void showPokemons(List<PokemonTO> pokemons) {
        view.showPokemons(pokemons);
    }

    @Override
    public void showError(String error) {
        view.showError(error);
    }
}
