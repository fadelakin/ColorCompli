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

    Compliments compliment = new Compliments();
    TextView complimentText;
    Button getAnotherCompliment;
    private String mColor;

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

        if(mColor == null) {
            mColor = "blue";
        }

        switch (mColor) {
            case "turquoise":
                layout.setBackgroundColor(Color.rgb(26, 188, 156));
                break;
            case "emerald":
                layout.setBackgroundColor(Color.rgb(46, 204, 113));
                break;
            case "green":
                layout.setBackgroundColor(Color.GREEN);
                break;
            case "blue":
                layout.setBackgroundColor(Color.rgb(41, 128, 185));
                break;
            case "orange":
                layout.setBackgroundColor(Color.rgb(243, 156, 18));
                break;
            case "yellow":
                layout.setBackgroundColor(Color.YELLOW);
                break;
            case "gray":
                layout.setBackgroundColor(Color.GRAY);
                break;
            case "purple":
                layout.setBackgroundColor(Color.rgb(142, 68, 173));
                break;
            case "red":
                layout.setBackgroundColor(Color.RED);
                break;
            default:
                Toast.makeText(this, "Sorry, but your color isn't available. Reverting to default.", Toast.LENGTH_SHORT);
                layout.setBackgroundColor(Color.rgb(52, 152, 219));
                break;
        }
        getAnotherCompliment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
