package com.fisheradelakin.colorcompli;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    Button mHelpButton;
    EditText mColorField;
    Button mGetCompliments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelpButton = (Button) findViewById(R.id.getHelpButton);
        mColorField = (EditText) findViewById(R.id.colorEditText);
        mGetCompliments = (Button) findViewById(R.id.getComplimentsButton);

        // Help Button opens a dialog of info to the user
        mHelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new HelpDialogFragment();
                newFragment.show(getFragmentManager(), "help");
            }
        });

        // Get compliments and change the background color
        mGetCompliments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mColorField.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Please enter your favorite color", Toast.LENGTH_SHORT).show();
                } else {
                    String color = mColorField.getText().toString();
                    giveCompliments(color);
                }
            }
        });
    }

    private void giveCompliments(String color) {
        Intent intent = new Intent(this, ComplimentsActivity.class);
        intent.putExtra(getString(R.string.key_color), color);
        startActivity(intent);
    }

    public static class HelpDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(R.string.what_colors)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

            return builder.create();
        }
    }
}
