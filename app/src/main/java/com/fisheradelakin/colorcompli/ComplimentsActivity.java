package com.fisheradelakin.colorcompli;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class ComplimentsActivity extends ActionBarActivity {

    private Compliments compliment = new Compliments();
    TextView complimentText;
    Button getAnotherCompliment;
    String mColor;

    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compliments);

        Intent intent = getIntent();
        mColor = intent.getStringExtra(getString(R.string.key_color).toLowerCase());

        complimentText = (TextView) findViewById(R.id.complimentsTextView);
        getAnotherCompliment = (Button) findViewById(R.id.getAnotherCompliment);
        layout = (RelativeLayout) findViewById(R.id.layout);

        switch (mColor) {
            case "turquoise":
                layout.setBackgroundColor(Color.rgb(26, 188, 156));
                getAnotherCompliment.setBackgroundColor(Color.rgb(26, 188, 156));
                break;
            case "emerald":
                layout.setBackgroundColor(Color.rgb(46, 204, 113));
                getAnotherCompliment.setBackgroundColor(Color.rgb(46, 204, 113));
                break;
            case "green":
                layout.setBackgroundColor(Color.rgb(39, 174, 96));
                getAnotherCompliment.setBackgroundColor(Color.rgb(39, 174, 96));
                break;
            case "blue":
                layout.setBackgroundColor(Color.rgb(41, 128, 185));
                getAnotherCompliment.setBackgroundColor(Color.rgb(41, 128, 185));
                break;
            case "orange":
                layout.setBackgroundColor(Color.rgb(211, 84, 0));
                getAnotherCompliment.setBackgroundColor(Color.rgb(211, 84, 0));
                break;
            case "yellow":
                layout.setBackgroundColor(Color.rgb(241, 196, 15));
                getAnotherCompliment.setBackgroundColor(Color.rgb(241, 196, 15));
                break;
            case "gray":
                layout.setBackgroundColor(Color.GRAY);
                getAnotherCompliment.setBackgroundColor(Color.GRAY);
                break;
            case "purple":
                layout.setBackgroundColor(Color.rgb(142, 68, 173));
                getAnotherCompliment.setBackgroundColor(Color.rgb(142, 68, 173));
                break;
            case "red":
                layout.setBackgroundColor(Color.rgb(192, 57, 43));
                getAnotherCompliment.setBackgroundColor(Color.rgb(192, 57, 43));
                break;
            default:
                Toast.makeText(this, "Sorry, but your color isn't available. Reverting to default.", Toast.LENGTH_SHORT).show();
                layout.setBackgroundColor(Color.rgb(52, 152, 219));
                break;
        }

        getAnotherCompliment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String compli = compliment.getCompliment();
                complimentText.setText(compli);
            }
        });

    }
}
