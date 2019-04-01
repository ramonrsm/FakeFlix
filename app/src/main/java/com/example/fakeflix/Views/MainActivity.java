package com.example.fakeflix.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.fakeflix.Controllers.CatalogMovieAdapter;
import com.example.fakeflix.Controllers.MovieCatalog;
import com.example.fakeflix.Controllers.RecyclerViewOnClickListener;
import com.example.fakeflix.Models.Entities.Movie;
import com.example.fakeflix.Models.Enums.Category;
import com.example.fakeflix.R;
public class MainActivity extends AppCompatActivity implements RecyclerViewOnClickListener {

    public static final int MAIN_ACTIVITY = 1;

    private MovieCatalog movieCatalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar_menu = findViewById(R.id.toolbar_menu);
        toolbar_menu.setTitle("FakeFlix");

        movieCatalog = MovieCatalog.getInstance();
        popularLista(5);

        RecyclerView recyclerView_catalog_trending = findViewById(R.id.recyclerView_catalog_trending);
        CatalogMovieAdapter catalogFeatureFilmAdapter = new CatalogMovieAdapter(movieCatalog.findByCategory(Category.FEATURE_FILM));
        catalogFeatureFilmAdapter.setRecyclerViewOnClickListener(this);

        LinearLayoutManager layoutManager_trending = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView_catalog_trending.setLayoutManager(layoutManager_trending);
        recyclerView_catalog_trending.setAdapter(catalogFeatureFilmAdapter);

        RecyclerView recyclerView_catalog_releases = findViewById(R.id.recyclerView_catalog_releases);
        CatalogMovieAdapter catalogFeatureFilmAdapter_releases = new CatalogMovieAdapter(movieCatalog.findByCategory(Category.SHORT_FILM));
        catalogFeatureFilmAdapter_releases.setRecyclerViewOnClickListener(this);

        LinearLayoutManager layoutManager_releases = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView_catalog_releases.setLayoutManager(layoutManager_releases);
        recyclerView_catalog_releases.setAdapter(catalogFeatureFilmAdapter_releases);

        RecyclerView recyclerView_catalog_series = findViewById(R.id.recyclerView_catalog_series);
        CatalogMovieAdapter catalogFeatureFilmAdapter_series = new CatalogMovieAdapter(movieCatalog.findByCategory(Category.SERIES));
        catalogFeatureFilmAdapter_series.setRecyclerViewOnClickListener(this);

        LinearLayoutManager layoutManager_series = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView_catalog_series.setLayoutManager(layoutManager_series);
        recyclerView_catalog_series.setAdapter(catalogFeatureFilmAdapter_series);
    }

    public void popularLista(int quantidade){

        Movie movie;

        for (int i = 0; i < quantidade; i++){
            movie = new Movie();
            movie.setId(i);
            movie.setName("Filme "+i);
            movie.setSynopsis("Sinopse "+i);
            movie.setFetureImage(null);
            movie.setCategory(Category.FEATURE_FILM);
            movieCatalog.save(movie);
        }

        for (int i = 0; i < quantidade; i++){
            movie = new Movie();
            movie.setId(i);
            movie.setName("Curta Metragem "+i);
            movie.setSynopsis("Sinopse "+i);
            movie.setFetureImage(null);
            movie.setCategory(Category.SHORT_FILM);
            movieCatalog.save(movie);
        }

        for (int i = 0; i < quantidade; i++){
            movie = new Movie();
            movie.setId(i);
            movie.setName("Série "+i);
            movie.setSynopsis("Sinopse "+i);
            movie.setFetureImage(null);
            movie.setCategory(Category.SERIES);
            movieCatalog.save(movie);
        }
    }

    @Override
    public void onClickListener(View view, int positon, Category category) {

        Bundle indexMovie = new Bundle();
        indexMovie.putInt("MOVIE", positon);

        indexMovie.putString("MOVIE", category.toString());

        Intent infoIntent = new Intent(this, InfoActivity.class);
        infoIntent.putExtras(indexMovie);

        startActivityForResult(infoIntent, MAIN_ACTIVITY);
    }
}
