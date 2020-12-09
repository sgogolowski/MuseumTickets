package com.example.cs213project4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.List;
/**
 * Main Activity for the museum tickets application.
 * Initializes the list view with the 4 NJ Museums and creates an event handler for when the
 * user selects a museum.
 * @authors Szymon Gogolowski, James Piedilato

 */
public class MainActivity extends AppCompatActivity {
    /**
     * Overrides onCreate method.
     * Initialize list view with all museums and create event handler for it.
     * @param savedInstanceState is the saved instance state

     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Find list view object by id
        ListView museum_lv =  (ListView) findViewById(R.id.museums_lv);
        //Event handler to change activities when selecting a museum
        museum_lv.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(getApplicationContext(), SecondActivity.class);
                myIntent.putExtra("MUSEUM_SELECTED", (String) museum_lv.getItemAtPosition(position));
                startActivity(myIntent);
            }
        });
    }
}