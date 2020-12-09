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
/**
 * Second Activity for the museum tickets application.
 * Initializes the view with the appropriate ticket prices and image for the selected museum from
 * the previous activity. Then it prompts the user to select the amount of tickets for the appropriate museum
 * and calculates the total cost and sales tax.
 * @authors Szymon Gogolowski, James Piedilato

 */
public class SecondActivity extends AppCompatActivity {
    /**
     * Overridden onCreate method that sets up the view of the activity.
     * Sets the appropriate image and ticket prices of the museums according to the selected museum
     * from the previous activity

     */
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

    /**
     * Method to show the user a toast message.
     * Shows the user a toast message about the maximum tickets possible for each age group.
     * @param view is the current view

     */
    public void showToast(SecondActivity view){
        Toast maxTickets = Toast.makeText(this, R.string.toast, Toast.LENGTH_SHORT);
        maxTickets.show();
    }
    /**
     * Helper method to initialize the text fields to display the correct ticket price for the
     * selected museum.
     * @param museum is a string representation of the selected museum

     */
    private void setPrice(String museum){
        TextView adult = (TextView) findViewById(R.id.adultPrice);
        TextView senior = (TextView) findViewById(R.id.seniorPrice);
        TextView student = (TextView) findViewById(R.id.studentPrice);

        switch (museum) {
            case "Liberty Science Center":
                adult.setText(R.string.lcs_adult);
                student.setText(R.string.lcs_student);
                senior.setText(R.string.lcs_senior);
                break;
            case "Newark Museum of Art":
                adult.setText(R.string.nma_adult);
                student.setText(R.string.nma_student);
                senior.setText(R.string.nma_senior);
                break;
            case "Franklin Mineral Museum":
                adult.setText(R.string.fmm_adult);
                student.setText(R.string.fmm_student);
                senior.setText(R.string.fmm_senior);
                break;
            case "Montclair Art Museum":
                adult.setText(R.string.mam_adult);
                student.setText(R.string.mam_student);
                senior.setText(R.string.mam_senior);
                break;
            default:
                break;
        }
    }
    /**
     * Helper method to set the image view to the appropriate image of the selected museum.
     * @param museum is the string representation of the selected museum

     */
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

    /**
     * Event handler method to calculate the ticket costs and display them.
     * Extract the cost of each ticket and the number of selected tickets by the user. Multiply them
     * then calculate sales tax. Set the text view for the price to each corresponding field.
     * @param view is the view to calculate ticket cost from

     */
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

    /**
     * Event handler method to go the museum website when the user clicks on the museum image.
     * Starts the 3rd activity implicitly.
     * @param view is the view that the image is on.

     */
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
