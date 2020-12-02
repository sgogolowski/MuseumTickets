package com.example.cs213project4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.ticket_calculator);
        Bundle myBundle = getIntent().getExtras();

        String museum = myBundle.getString("MUSEUM_SELECTED");
        TextView title = (TextView) findViewById(R.id.museumTitle);
        title.setText(museum);

        setImage(museum);
        setPrice(museum);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.num_tickets, android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
        showToast(this);
    }


    public void showToast(SecondActivity view){
        Toast maxTickets = Toast.makeText(this, "Maximum of 5 Tickets for each!", Toast.LENGTH_SHORT);
        maxTickets.show();
    }

    private void setPrice(String museum){
        TextView adult = (TextView) findViewById(R.id.adultPrice);
        TextView senior = (TextView) findViewById(R.id.seniorPrice);
        TextView student = (TextView) findViewById(R.id.studentPrice);

        switch (museum) {
            case "Liberty Science Center":
                adult.setText("$24.99");
                student.setText("$19.99");
                senior.setText("$17.99");
                break;
            case "Newark Museum of Art":
                adult.setText("$15");
                student.setText("$8");
                senior.setText("$8");
                break;
            case "Franklin Mineral Museum":
                adult.setText("$15");
                student.setText("$12");
                senior.setText("$14");
                break;
            case "Montclair Art Museum":
                adult.setText("$15");
                student.setText("$12");
                senior.setText("$12");
                break;
            default:
                break;
        }
    }

    private void setImage(String museum){
        ImageView museumImage = (ImageView) findViewById(R.id.museumImage);
        switch (museum){
            case "Liberty Science Center":
                museumImage.setImageResource(R.drawable.lsc);
                break;
            case "Franklin Mineral Museum":
                museumImage.setImageResource(R.drawable.fmm);
                break;
            case "Montclair Art Museum":
                museumImage.setImageResource(R.drawable.mam);
                break;
            case "Newark Museum of Art":
                museumImage.setImageResource(R.drawable.nmoa);
                break;
            default:
                break;
        }
    }

    public void calculateTicketCost(View view){
        Spinner adultSpinner = (Spinner) findViewById(R.id.spinner1);
        Spinner seniorSpinner = (Spinner) findViewById(R.id.spinner2);
        Spinner studentSpinner = (Spinner) findViewById(R.id.spinner3);

        TextView ticketsPrice = (TextView) findViewById(R.id.ticketPrice);
        TextView salesTax = (TextView) findViewById(R.id.salesTax);
        TextView totalPrice = (TextView) findViewById(R.id.totalPrice);

        double adultPrice = Double.valueOf(((String) ((TextView) findViewById(R.id.adultPrice)).getText()).substring(1));
        double seniorPrice = Double.valueOf(((String) ((TextView) findViewById(R.id.seniorPrice)).getText()).substring(1));
        double studentPrice = Double.valueOf (((String) ((TextView) findViewById(R.id.studentPrice)).getText()).substring(1));

        int adultTickets = Integer.valueOf((String) adultSpinner.getSelectedItem());
        int seniorTickets = Integer.valueOf((String) seniorSpinner.getSelectedItem());
        int studentTickets = Integer.valueOf((String) studentSpinner.getSelectedItem());

        double tickets_price = (adultTickets * adultPrice) + (seniorTickets * seniorPrice) + (studentTickets * studentPrice);
        ticketsPrice.setText(String.format("$%.2f", tickets_price));
        double sales_tax = (double) tickets_price * 0.06625;
        salesTax.setText(String.format("$%.2f", sales_tax));
        totalPrice.setText(String.format("$%.2f", tickets_price + sales_tax));

    }

    public void goToWebsite(View view){
        TextView title = (TextView) findViewById(R.id.museumTitle);
        switch ((String) title.getText()){
            case "Liberty Science Center":
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://lsc.org")));
                break;
            case "Newark Museum of Art":
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.newarkmuseumart.org")));
                break;
            case "Montclair Art Museum":
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.montclairartmuseum.org")));
                break;
            case "Franklin Mineral Museum":
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://franklinmineralmuseum.com")));
                break;
            default:
                break;
        }
    }
}
