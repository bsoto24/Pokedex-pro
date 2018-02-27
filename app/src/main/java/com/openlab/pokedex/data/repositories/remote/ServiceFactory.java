package com.openlab.pokedex.data.repositories.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bryam Soto on 27/02/2018.
 */

public class ServiceFactory {

    private static final String BASE_URL = "http://pokeapi.co/api/v2/";

    public static Retrofit retrofit =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();

}
