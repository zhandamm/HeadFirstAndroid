package com.example.testmenu;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import beeradviser.BeerExpert;

public class MainActivity extends AppCompatActivity {
    private final BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.find_beer);
        button.setOnClickListener(this::onClickFindBeer);
    }


    public void onClickFindBeer(View view) {

        TextView brands = findViewById(R.id.brands);
        Spinner color = findViewById(R.id.color);
        String beerType = String.valueOf(color.getSelectedItem());
        List<String> brandList = expert.getBrands(beerType);
        StringBuilder stringBuilder = new StringBuilder();
        for (String brand : brandList) {
            stringBuilder.append(brand);
        }
        brands.setText(stringBuilder);

    }


}