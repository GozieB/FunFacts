package com.gozieb.funfacts;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;


public class FunFactsActivity extends ActionBarActivity {
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Declare our view variables and assign them the views from the layout file
        final TextView factLabel = (TextView) findViewById(R.id.factsTextView);
        final Button showFactButton = (Button) findViewById(R.id.showFactsButton);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String fact = mFactBook.getFact();
                int color = mColorWheel.getColor();
                relativeLayout.setBackgroundColor(color);
                showFactButton.setTextColor(color);

               // Update the label with a dynamic fact...
                factLabel.setText(fact);

            }
        };
        showFactButton.setOnClickListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fun_facts, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
