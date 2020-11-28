package com.example.cs213project4;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.ticket_calculator);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.num_tickets, android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);

    }
}
