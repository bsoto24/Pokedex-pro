package com.openlab.pokedex.data.repositories.remote.service;

import com.openlab.pokedex.data.entity.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Bryam Soto on 27/02/2018.
 */

public interface PokemonsService {

    @GET("pokemon")
    Call<Result> getPokemons(@Query("limit") int limit, @Query("offset") int offset);

}