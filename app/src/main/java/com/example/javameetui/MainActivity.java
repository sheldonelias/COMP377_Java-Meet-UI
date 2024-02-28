package com.example.javameetui;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    // An int declared to hold a value
    private int value = 0;

    // All views are declared
    private Button btnAdd;
    private Button btnTake;
    private Button btnGrow;
    private Button btnShrink;
    private Button btnReset;
    private Button btnHide;
    private Button btnNulify;


    private TextView txtValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Stores a reference to all declared View objects
        btnAdd = findViewById(R.id.btnAdd);
        btnTake = findViewById(R.id.btnTake);
        btnGrow = findViewById(R.id.btnGrow);
        btnShrink = findViewById(R.id.btnShrink);
        btnReset = findViewById(R.id.btnReset);
        btnHide = findViewById(R.id.btnHide);
        btnNulify = findViewById(R.id.btnNulify);

        txtValue = findViewById(R.id.txtValue);

        // Listen for all the button clicks on this Activity
        btnAdd.setOnClickListener(this);
        btnTake.setOnClickListener(this);
        btnGrow.setOnClickListener(this);
        btnShrink.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnHide.setOnClickListener(this);
        btnNulify.setOnClickListener(this);

        txtValue.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

            // A local variable to use later
            float size;

            //Converts id to a number and stores to an int var
            int id = view.getId();
            //Declares a Toast message for messaging to the user/developer
            Toast message;
            if (id == R.id.btnAdd)
            {
                value++;
                txtValue.setText("" + value);

                message = Toast.makeText(this, "Add pressed.", Toast.LENGTH_SHORT);
                message.show();

            } else if (id == R.id.btnTake) {
                value--;
                txtValue.setText("" + value);

                message = Toast.makeText(this, "Take pressed.", Toast.LENGTH_SHORT);
                message.show();
            } else if (id == R.id.btnReset) {
                value = 0;
                txtValue.setText("" + value);

                message = Toast.makeText(this, "Reset pressed.", Toast.LENGTH_SHORT);
                message.show();
            } else if (id == R.id.btnGrow) {
                size = txtValue.getTextScaleX();
                txtValue.setTextScaleX(size + 1);

                message = Toast.makeText(this, "Grow pressed.", Toast.LENGTH_SHORT);
                message.show();
            } else if (id == R.id.btnShrink) {
                size = txtValue.getTextScaleX();
                txtValue.setTextScaleX(size - 1);

                message = Toast.makeText(this, "Shrink pressed.", Toast.LENGTH_SHORT);
                message.show();
            } else if (id == R.id.btnHide) {
                if (txtValue.getVisibility() == View.VISIBLE) {
                    // Currently visible so hide it
                    txtValue.setVisibility(View.INVISIBLE);

                    // Change text on the button
                    btnHide.setText("Show");

                    message = Toast.makeText(this, "Show pressed.", Toast.LENGTH_SHORT);
                    message.show();

                } else {
                    // Currently hidden so show it
                    txtValue.setVisibility(View.VISIBLE);

                    // Change text on the button
                    btnHide.setText("Hide");

                    message = Toast.makeText(this, "Hide pressed.", Toast.LENGTH_SHORT);
                    message.show();
                }
            }else if(id == R.id.btnNulify)
            {
                //Setup a graceful exception catch. Experiment by recoding without
                //the try/catch to make the app crash
                try {
                    txtValue = null;
                    //This line below will cause an exception
                    txtValue.setText("Test will throw exception.");
                } catch (NullPointerException excpt)
                {
                    message = Toast.makeText(this, "Null pointer called!", Toast.LENGTH_SHORT);
                    message.show();

                    //This line restores the reference
                    txtValue = findViewById(R.id.txtValue);
                }
                //Never going to be used, but good practice no matter
            } else {
                System.out.println("Invalid case provided.");
        }
    }
}