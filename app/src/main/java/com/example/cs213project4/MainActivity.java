package com.example.cs213project4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
        museum_lv.setOnClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}