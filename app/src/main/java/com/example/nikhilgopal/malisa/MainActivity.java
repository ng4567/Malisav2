package com.example.nikhilgopal.malisa;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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



    public void bestfitline(View view) {

        EditText X1 = (EditText) findViewById(R.id.X1); // this gets X2, returns as a float
        double first_x = Double.parseDouble(X1.getText().toString());

        EditText X2 = (EditText) findViewById(R.id.X2); // this gets X2, returns as a float
        double second_x = Double.parseDouble(X2.getText().toString());

        EditText X3 = (EditText) findViewById(R.id.X3); // this gets X3, returns as a float
        double third_x = Double.parseDouble(X3.getText().toString());

        EditText X4 = (EditText) findViewById(R.id.X4); // this gets X2, returns as a float
        double fourth_x = Double.parseDouble(X4.getText().toString());


        EditText Y1 = (EditText) findViewById(R.id.Y1); // this gets Y1, returns as a float
        double first_y = Double.parseDouble(Y1.getText().toString());

        EditText Y2 = (EditText) findViewById(R.id.Y2); // this gets Y2, returns as a float
        double second_y = Double.parseDouble(Y2.getText().toString());

        EditText Y3 = (EditText) findViewById(R.id.Y3); // this gets Y2, returns as a float
        double third_y = Double.parseDouble(Y3.getText().toString());


        // slope = (Nxysum) - (xsumysum)/(Nx2sum) - (xsumxsum)
        // y-intercept = (x2sumysum) - (xsumxysum)/(Nx2sum) - (xsumxsum)


        double x_sum = first_x + second_x + third_x;

        double y_sum = first_y + second_y + third_y;

        double xysum = (first_x * first_y) + (second_x * second_y) + (third_x * third_y);

        double x2sum = Math.pow(first_x, 2) + Math.pow(second_x, 2) + Math.pow(third_x, 2);

        double y2sum = Math.pow(first_y, 2) + Math.pow(second_y, 2) + Math.pow(third_y, 2);

        double N = 3;

        double slope = ((N * xysum) - (x_sum * y_sum))/((N * x2sum) - (x_sum * x_sum));

        double y_intercept = ((x2sum * y_sum) - (x_sum *xysum))/((N * x2sum) - (x2sum * x2sum));

        // concentration = input * slope + y intercept

        double concentration = (fourth_x * slope) + y_intercept;
        String equation_string ="X *" + slope + y_intercept;
        String display_this_value =  "Concentration: " + concentration;


        Toast display_final_value = Toast.makeText(getApplicationContext(), new String(display_this_value), Toast.LENGTH_SHORT);

        display_final_value.show();


    }

}



