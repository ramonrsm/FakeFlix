package com.example.fakeflix.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fakeflix.Controllers.CatalogFeatureFilmAdapter;
import com.example.fakeflix.Controllers.RecyclerViewOnClickListener;
import com.example.fakeflix.Models.Entities.Catalog;
import com.example.fakeflix.Models.Entities.FeatureFilm;
import com.example.fakeflix.R;
import com.example.fakeflix.Util.Helpers;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewOnClickListener {

    public static final int MAIN_ACTIVITY = 1;

    private RecyclerView recyclerViewFeatureFilme;
    private CatalogFeatureFilmAdapter catalogFeatureFilmAdapter;
    private List<FeatureFilm> featureFilmList;
    private Catalog catalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewFeatureFilme = findViewById(R.id.recyclerView_catalog_featureFilm);

        catalog = Catalog.getInstance();

        popularLista(5);

        featureFilmList = catalog.getFeatureFilmList();

        catalogFeatureFilmAdapter = new CatalogFeatureFilmAdapter(featureFilmList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewFeatureFilme.setLayoutManager(layoutManager);
        recyclerViewFeatureFilme.setAdapter(catalogFeatureFilmAdapter);
        catalogFeatureFilmAdapter.setRecyclerViewOnClickListener(this);
    }

    public void popularLista(int quantidade){

        FeatureFilm featureFilm;

        for (int i = 0; i <= quantidade; i++){
            featureFilm = new FeatureFilm(i, "Filme "+i, getDrawable(R.drawable.ic_launcher_background), "Sinopse "+i);
            catalog.add(featureFilm);
        }
    }

    @Override
    public void onClickListener(View view, int positon) {
        Bundle indexMovie = new Bundle();
        indexMovie.putInt("MOVIE", positon);

        Intent infoIntent = new Intent(this, InfoActivity.class);
        infoIntent.putExtras(indexMovie);

        startActivityForResult(infoIntent, MAIN_ACTIVITY);

        Toast.makeText(view.getContext(), "Posição: "+positon+", "+featureFilmList.get(positon).getName(), Toast.LENGTH_SHORT).show();
    }
}
