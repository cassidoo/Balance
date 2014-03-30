package com.example.balance.app;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.*;
import android.widget.AbsoluteLayout.LayoutParams;
import java.util.logging.*;


public class MainActivity extends ActionBarActivity {

    private LinearLayout btn_ll;
    private LinearLayout.LayoutParams btn_lp;

    private Button btn_opt1;
    private Button btn_opt2;
    private Button btn_opt3;

    private ProgressBar gradeBar;
    private ProgressBar happyBar;
    private ProgressBar energyBar;

    private TextView moneyAmountView;

    private int moneyAmount;
    private int gradeBarProgress;
    private int happyBarProgress;
    private int energyBarProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //Construct new Objects and Values

        //Instantiate objects and values
        btn_opt1 = (Button) findViewById(R.id.btn_opt1);
        btn_opt2 = (Button) findViewById(R.id.btn_opt2);
        btn_opt3 = new Button(this);

        gradeBar = (ProgressBar) findViewById(R.id.progressBar2);
        gradeBar.setMax(100);
        happyBar = (ProgressBar) findViewById(R.id.progressBar3);
        happyBar.setMax(100);
        energyBar = (ProgressBar) findViewById(R.id.progressBar4);
        energyBar.setMax(100);


        btn_ll = (LinearLayout)findViewById(R.id.btn_layout);
        btn_lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        moneyAmountView = (TextView) findViewById(R.id.moneyAmount);
        //Temporary for Demo Purposes
        moneyAmount = 1000;
        moneyAmountView.setText("$" + moneyAmount);
        moneyAmountView.setTextSize(55);

        gradeBarProgress = 100;
        happyBarProgress = 100;
        energyBarProgress = 100;

        gradeBar.setProgress(gradeBarProgress);
        happyBar.setProgress(happyBarProgress);
        energyBar.setProgress(energyBarProgress);

        btn_opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumButtons(3, "Test", "Hey", "Nothing");
            }
        });

        btn_opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumButtons(2, "Test", "Hey", "Nothing");
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    private void addNumButtons(int numButtons, String scenario1, String scenario2, String scenario3){
        if(numButtons == 1){
            btn_opt1.setText(scenario1);

            btn_ll.addView(btn_opt1, btn_lp);
        }
        else if(numButtons == 2){
            btn_opt1.setText(scenario1);
            btn_opt2.setText(scenario2);

            if(btn_opt3.getVisibility() == View.VISIBLE){
                btn_ll.removeView(btn_opt3);
            }

        }
        else if(numButtons == 3){
            btn_opt1.setText(scenario1);
            btn_opt2.setText(scenario2);
            btn_opt3.setText(scenario3);

            btn_ll.addView(btn_opt3, btn_lp);
        }
        else{
            //Do nothing
        }
    }

    private void addMoney(int increment){
        moneyAmount = moneyAmount + increment;
    }

    private void addGrade(int increment){
        gradeBar.setProgress(gradeBarProgress + increment);
    }

    private void addHappy(int increment){
        happyBar.setProgress(happyBarProgress + increment);
    }

    private void addEnergy(int increment){
        energyBar.setProgress(energyBarProgress + increment);
    }

    private void subtractMoney(int decrement){
        moneyAmount = moneyAmount - decrement;
    }

    private void subtractGrade(int decrement){
        gradeBar.setProgress(gradeBarProgress - decrement);
    }

    private void subtractHappy(int decrement){
        happyBar.setProgress(happyBarProgress - decrement);
    }

    private void subtractEnergy(int decrement){
        energyBar.setProgress(energyBarProgress - decrement);
    }

}
