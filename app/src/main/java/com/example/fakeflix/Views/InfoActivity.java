package com.example.fakeflix.Views;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.fakeflix.Controllers.MovieCatalog;
import com.example.fakeflix.Models.Entities.Movie;
import com.example.fakeflix.Models.Enums.Category;
import com.example.fakeflix.R;
import com.example.fakeflix.Util.Helpers;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Toolbar toolbar_info = findViewById(R.id.toolbar_info);
        toolbar_info.setTitle("");
        toolbar_info.setNavigationOnClickListener(this);
        setSupportActionBar(toolbar_info);

        ActionBar actionBar = getSupportActionBar();

        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        TextView  textView_Name     = findViewById(R.id.textView_Name);
        TextView  textView_Synopsis = findViewById(R.id.textView_Synopsis);

        MovieCatalog movieCatalog = MovieCatalog.getInstance();

        Intent infoMovie = getIntent();

        if(infoMovie != null){

            Bundle indexMovie = infoMovie.getExtras();

            if(indexMovie != null){

                Category category = Category.valueOf(indexMovie.getString("category"));

                Movie movie = movieCatalog.findByCategory(category).get(indexMovie.getInt("position"));

                textView_Name.setText(movie.getName());
                textView_Synopsis.setText(movie.getSynopsis());
            }
        }
    }

    @Override
    public void onClick(View v) {
        Helpers.goToActivity(InfoActivity.this, MainActivity.class);
    }
}
