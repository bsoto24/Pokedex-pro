package com.openlab.pokedex.ui.pokemons;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.openlab.pokedex.R;
import com.openlab.pokedex.data.entity.PokemonTO;

import java.util.List;

public class PokemonActivity extends AppCompatActivity implements Pokemon.View {

    private RecyclerView rvPokemons;
    private GridLayoutManager layoutManager;
    private PokemonAdapter adapter;
    private com.openlab.pokedex.ui.pokemons.Pokemon.Presenter presenter;

    private int offset = 0;
    private boolean cargar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemons);

        rvPokemons = findViewById(R.id.rv_pokemons);
        layoutManager = new GridLayoutManager(this, 2);
        rvPokemons.setLayoutManager(layoutManager);
        adapter = new PokemonAdapter(this);
        rvPokemons.setAdapter(adapter);

        rvPokemons.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (cargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {

                            cargar = false;
                            offset += 20;
                            presenter.getPokemons(offset);

                        }
                    }
                }

            }
        });

        presenter = new PokemonPresenter(this);

        presenter.getPokemons(offset);

    }

    @Override
    public void showPokemons(List<PokemonTO> pokemons) {
        cargar = true;
        adapter.addPokemons(pokemons);
    }

    @Override
    public void showError(String error) {
        cargar = true;
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
