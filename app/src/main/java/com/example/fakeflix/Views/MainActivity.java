package com.example.fakeflix.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.example.fakeflix.Controllers.CatalogMovieAdapter;
import com.example.fakeflix.Controllers.MovieCatalog;
import com.example.fakeflix.Controllers.RecyclerViewOnClickListener;
import com.example.fakeflix.Models.Entities.Movie;
import com.example.fakeflix.Models.Enums.Category;
import com.example.fakeflix.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewOnClickListener {

    public static final int MAIN_ACTIVITY = 1;

    private MovieCatalog movieCatalog;
    private List<Movie>  movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieCatalog = MovieCatalog.getInstance();
        popularLista(5);
        movieList = movieCatalog.findAll();

        for (Movie movie : movieList) {
            Log.i("MOVIE", movie.toString());
        }

        RecyclerView recyclerView_catalog = findViewById(R.id.recyclerView_catalog);

        CatalogMovieAdapter catalogFeatureFilmAdapter = new CatalogMovieAdapter(movieList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView_catalog.setLayoutManager(layoutManager);
        recyclerView_catalog.setAdapter(catalogFeatureFilmAdapter);

        catalogFeatureFilmAdapter.setRecyclerViewOnClickListener(this);
    }

    public void popularLista(int quantidade){

        Movie movie;

        for (int i = 0; i <= quantidade; i++){
            movie = new Movie();
            movie.setId(i);
            movie.setName("Filme "+i);
            movie.setSynopsis("Sinopse "+i);
            movie.setFetureImage(getDrawable(R.drawable.ic_launcher_background));
            movie.addCategory(Category.FEATURE_FILM);
            movieCatalog.save(movie);
        }
    }

    @Override
    public void onClickListener(View view, int positon) {
        Bundle indexMovie = new Bundle();
        indexMovie.putInt("MOVIE", positon);

        Intent infoIntent = new Intent(this, InfoActivity.class);
        infoIntent.putExtras(indexMovie);

        startActivityForResult(infoIntent, MAIN_ACTIVITY);

        Toast.makeText(view.getContext(), "Posição: "+positon+", "+movieList.get(positon).getName(), Toast.LENGTH_SHORT).show();
    }
}
