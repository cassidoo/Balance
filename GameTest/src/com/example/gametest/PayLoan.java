package com.example.gametest;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.content.Intent;
import android.app.Activity;

public class PayLoan extends Activity {

	private TextView staticMsg;
	private TextView staticDollar;

	private EditText userAmtSpecify;

	private Button moneySend;
	private Button back;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pay_loan_screen);
		
		
		staticMsg = (TextView) findViewById(R.id.payLoanMsg);
		staticDollar = (TextView) findViewById(R.id.dollarSign);
		userAmtSpecify = (EditText) findViewById(R.id.userPayAmount);
		moneySend = (Button) findViewById(R.id.send);
		back = (Button) findViewById(R.id.back_button);
		
		
		staticMsg.setText("How much do you want to pay?");
		staticMsg.setTextSize(30);

		staticDollar.setTextSize(25);
		
		
		
		
		
		
		
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent i = new Intent(view.getContext(), MainActivity.class);
				startActivity(i);
			}
		});

		moneySend.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				String moneyPayOff = userAmtSpecify.getText().toString();
				Intent i = new Intent(view.getContext(), MainActivity.class);
				
				
				
				MainActivity.p.payLoan(Integer.parseInt(moneyPayOff));
				
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pay_screen, menu);
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
/*
	public void instantiate() {
		staticMsg = (TextView) findViewById(R.id.payLoanMsg);
		staticDollar = (TextView) findViewById(R.id.dollarSign);
		userAmtSpecify = (EditText) findViewById(R.id.userPayAmount);
		moneySend = (Button) findViewById(R.id.send);
		back = (Button) findViewById(R.id.back_button);
	}

	
	public void setViews() {
		staticMsg.setText("How much do you want to pay?");
		staticMsg.setTextSize(30);

		staticDollar.setTextSize(25);
	}*/
}
