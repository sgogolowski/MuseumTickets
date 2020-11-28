package com.example.cs213project4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] museums = {"Museum 1", "Museum 2", "Museum 3", "Museum 4"};
        ListView museum_lv =  (ListView) findViewById(R.id.museums_lv);
        ArrayAdapter<String> museum_adapter = new ArrayAdapter<>( this, android.R.layout.simple_list_item_1, museums);
        //ArrayAdapter<String> museum_adapter = new ArrayAdapter<>( this, android.R.layout.activity_list_item, R.id.museums_lv);
        museum_lv.setAdapter(museum_adapter);
    }
}