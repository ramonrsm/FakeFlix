package com.example.fakeflix.Views;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fakeflix.Models.Entities.Catalog;
import com.example.fakeflix.Models.Entities.FeatureFilm;
import com.example.fakeflix.R;

public class MainActivity extends AppCompatActivity {

    private Catalog catalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FeatureFilm avangers = new FeatureFilm(1, "Avengers: End game", "Após Thanos eliminar metade das criaturas vivas, os Vingadores têm de lidar com a perda de amigos e entes queridos. Com Tony Stark vagando perdido no espaço sem água e comida, Steve Rogers e Natasha Romanov lideram a resistência contra o titã louco.");



    }
}
