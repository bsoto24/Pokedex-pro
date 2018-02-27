package com.openlab.pokedex.ui.pokemons;

import android.util.Log;

import com.openlab.pokedex.data.entity.Result;
import com.openlab.pokedex.data.repositories.remote.ServiceFactory;
import com.openlab.pokedex.data.repositories.remote.service.PokemonsService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Bryam Soto on 27/02/2018.
 */

public class PokemonModel implements Pokemon.Model {

    private Pokemon.Presenter presenter;

    PokemonModel(Pokemon.Presenter presenter) {

        this.presenter = presenter;

    }

    @Override
    public void getPokemons(int offset) {

        final PokemonsService service = ServiceFactory.retrofit.create(PokemonsService.class);
        Call<Result> request = service.getPokemons(20, offset);

        request.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if (response.isSuccessful()) {

                    Result pokemons = response.body();
                    presenter.showPokemons(pokemons.getPokemons());

                } else {

                    presenter.showError("Error, el servicio no esta disponible");
                    Log.e("POKEMON:", "ERROR SUCCESSFUL");

                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

                presenter.showError("Error, revise su conexión a internet");
                Log.e("POKEMON:", "ERROR FAILURE");

            }
        });
    }
}
