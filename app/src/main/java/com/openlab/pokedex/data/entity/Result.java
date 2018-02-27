package com.openlab.pokedex.data.entity;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("previous")
    @Expose
    private Object previous;
    @SerializedName("results")
    @Expose
    private List<PokemonTO> pokemons = null;
    @SerializedName("next")
    @Expose
    private String next;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Result withCount(int count) {
        this.count = count;
        return this;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public Result withPrevious(Object previous) {
        this.previous = previous;
        return this;
    }

    public List<PokemonTO> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<PokemonTO> pokemons) {
        this.pokemons = pokemons;
    }

    public Result withResults(List<PokemonTO> pokemonTOS) {
        this.pokemons = pokemonTOS;
        return this;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Result withNext(String next) {
        this.next = next;
        return this;
    }

}