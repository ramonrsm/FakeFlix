package com.example.fakeflix.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.example.fakeflix.Controllers.CatalogMovieAdapter;
import com.example.fakeflix.Controllers.MovieCatalog;
import com.example.fakeflix.Controllers.RecyclerViewOnClickListener;
import com.example.fakeflix.Models.Entities.Movie;
import com.example.fakeflix.Models.Enums.Category;
import com.example.fakeflix.R;
import com.example.fakeflix.Util.Helpers;

public class MainActivity extends AppCompatActivity implements RecyclerViewOnClickListener {

    public static final int MAIN_ACTIVITY = 1;
    private static boolean addMovies = false;

    private MovieCatalog movieCatalog;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_exit:
                Helpers.goToActivity(this, LoginActivity.class);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar_menu = findViewById(R.id.toolbar_menu);
        toolbar_menu.setTitle("FakeFlix");
        setSupportActionBar(toolbar_menu);

        movieCatalog = MovieCatalog.getInstance();

        if(!addMovies){
            addFetureFilm(4);
            addShortFilm(3);
            addSerie(6);
        }

        addMovies = true;

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

    public void addFetureFilm(int amount){

        Movie movie;

        for (int i = 0; i < amount; i++){
            movie = new Movie();
            movie.setId(i);
            movie.setName("Filme "+i);
            movie.setSynopsis("Sinopse "+i);
            movie.setFetureImage(null);
            movie.setCategory(Category.FEATURE_FILM);
            movieCatalog.save(movie);
        }
    }

    public void addShortFilm(int amount){

        Movie movie;

        for (int i = 0; i < amount; i++){
            movie = new Movie();
            movie.setId(i);
            movie.setName("Curta Metragem "+i);
            movie.setSynopsis("Sinopse "+i);
            movie.setFetureImage(null);
            movie.setCategory(Category.SHORT_FILM);
            movieCatalog.save(movie);
        }
    }

    public void addSerie(int amount){

        Movie movie;

        for (int i = 0; i < amount; i++){
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
        indexMovie.putInt("position", positon);

        indexMovie.putString("category", category.toString());

        Intent infoIntent = new Intent(this, InfoActivity.class);
        infoIntent.putExtras(indexMovie);

        startActivityForResult(infoIntent, MAIN_ACTIVITY);
    }
}
