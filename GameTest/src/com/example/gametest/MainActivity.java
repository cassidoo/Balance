package com.example.gametest;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import java.util.Random;
import java.util.logging.*;
import android.app.Activity;
import android.view.Window;


public class MainActivity extends Activity {

    private LinearLayout btn_ll;
    private LinearLayout.LayoutParams btn_lp;

    private Button btn_opt1;
    private Button btn_opt2;
    private Button btn_opt3;
    private Button btn_payLoan;

    private ProgressBar gradeBar;
    private ProgressBar happyBar;
    private ProgressBar energyBar;

    private TextView moneyAmountView;
    private TextView loanAmountView;
    private TextView weekView;
    private TextView QView;

    private int moneyAmount;
    private int loanDebt;
    private int gradeBarProgress;
    private int happyBarProgress;
    private int energyBarProgress;
    private int week;
    public int count = 0;
	final Context context = this;
    
    public int firstIndex = 0;
    
    private Player p;
    private String[] answers;
    private Questions questions;
    private Random r;
    private final static int OTHER_SCREEN = 1;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        //Instantiate objects and values
        //question="";
       answers = new String[3];
        r = new Random();
        
        
        p = new Player(5000,100,100,100,12000);
        
        instantiate();
        
        
       
    }
    
    
 


/*
	@Override
	protected void onResume() {
    	super.onResume();  
    	
	}*/


    public void instantiate()
    {
    	questions = p.getQuestions();
    	moneyAmount = p.getCash();
        loanDebt = p.getLoan();
        gradeBarProgress = p.getGrades();
        happyBarProgress = p.getHappy();
        energyBarProgress = p.getEnergy();
        week = p.getWeek();
    	
    	btn_opt1 = (Button) findViewById(R.id.btn_opt1);
    	btn_opt1.setText("Start");
    	
        btn_opt2 = (Button) findViewById(R.id.btn_opt2);
        btn_opt2.setText("Exist");
        
    	if(week == 0)
    	{
    		btn_opt2.setVisibility(0);
    	}
        btn_opt3 = new Button(this);
        btn_payLoan = (Button) findViewById(R.id.pay_loan);

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
        moneyAmountView.setText("$" + moneyAmount);
        moneyAmountView.setTextSize(35);

        weekView = (TextView) findViewById(R.id.weekView);
        weekView.setText("Week: " + week);

        loanAmountView = (TextView) findViewById(R.id.loanView);
        loanAmountView.setText("Loans: $" + loanDebt);
        QView = (TextView)findViewById(R.id.situation);

        gradeBar.setProgress(gradeBarProgress);
        happyBar.setProgress(happyBarProgress);
        energyBar.setProgress(energyBarProgress);
        
        
        btn_opt1.setOnClickListener(new View.OnClickListener() {
        	@Override
            public void onClick(View view) {
                if(firstIndex == 0)
                {
            		btn_opt2.setVisibility(4);
            		QView.setText(questions.getQuestion(1, firstIndex));
            		btn_opt1.setText(questions.getAnswer(1, firstIndex)[0]);
            		btn_opt2.setText(questions.getAnswer(1, firstIndex)[1]);
            		p.updateFirst(firstIndex, 0);
            		firstIndex++;
                }
                
                if(firstIndex < 5)
                {
                	QView.setText(questions.getQuestion(1, firstIndex));
            		btn_opt1.setText(questions.getAnswer(1, firstIndex)[0]);
            		btn_opt2.setText(questions.getAnswer(1, firstIndex)[1]);
            		if(firstIndex == 3)
            		{
                		String[] answer = questions.getAnswer(1, firstIndex-1);
               			QView.setText(answer[0]);
            		}
            		p.updateFirst(firstIndex, 0);
            		firstIndex++;
                }
        		
        		if(count < 33)
        		{
        			int x = r.nextInt(10);
        			if(x < 3)
        			{
        				int depRand = r.nextInt(6);
        				QView.setText(questions.getQuestion(3, depRand));
        				btn_opt1.setText(questions.getAnswer(3, depRand)[0]);
                		btn_opt2.setText(questions.getAnswer(3, depRand)[1]);
        				
        				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        		        // set title
        			    alertDialogBuilder.setTitle("End of week");
        		 
        					// set dialog message
        					alertDialogBuilder.setMessage(p.updateDepend(depRand, 0) + '\n' + p.getMsg())
        						.setCancelable(false)
        						.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
        							public void onClick(DialogInterface dialog,int id) {
        								// if this button is clicked, close
        								// current activity
        								dialog.cancel();
        							}
        						  })
        						/*.setNegativeButton("No",new DialogInterface.OnClickListener() {
        							public void onClick(DialogInterface dialog,int id) {
        								// if this button is clicked, just close
        								// the dialog box and do nothing
        								dialog.cancel();
        							}
        						})*/;
        		 
        						// create alert dialog
        						AlertDialog alertDialog = alertDialogBuilder.create();
        		 
        						// show it
        						alertDialog.show();
        			}
        			else
        			{
        				int randRand = r.nextInt(34);
        				QView.setText(questions.getQuestion(2, randRand));
        				btn_opt1.setText(questions.getAnswer(2, randRand)[0]);
                		btn_opt2.setText(questions.getAnswer(2, randRand)[1]);
        				
        				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        		        // set title
        			    alertDialogBuilder.setTitle("End of week");
        		 
        					// set dialog message
        					alertDialogBuilder.setMessage(p.updateRan(randRand, 0) + '\n' + p.getMsg())
        						.setCancelable(false)
        						.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
        							public void onClick(DialogInterface dialog,int id) {
        								// if this button is clicked, close
        								// current activity
        								MainActivity.this.finish();
        							}
        						  })
        						/*.setNegativeButton("No",new DialogInterface.OnClickListener() {
        							public void onClick(DialogInterface dialog,int id) {
        								// if this button is clicked, just close
        								// the dialog box and do nothing
        								dialog.cancel();
        							}
        						})*/;
        		 
        						// create alert dialog
        						AlertDialog alertDialog = alertDialogBuilder.create();
        		 
        						// show it
        						alertDialog.show();
        			}
        			count++;
                }
                
            }
        });

        btn_opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstIndex == 0)
                {
            		btn_opt2.setVisibility(4);
            		QView.setText(questions.getQuestion(1, firstIndex));
            		btn_opt1.setText(questions.getAnswer(1, firstIndex)[0]);
            		btn_opt2.setText(questions.getAnswer(1, firstIndex)[1]);
            		p.updateFirst(firstIndex, 1);
            		firstIndex++;
                }
                
                if(firstIndex < 5)
                {
                	QView.setText(questions.getQuestion(1, firstIndex));
            		btn_opt1.setText(questions.getAnswer(1, firstIndex)[0]);
            		btn_opt2.setText(questions.getAnswer(1, firstIndex)[1]);
            		if(firstIndex == 3)
            		{
                		String[] answer = questions.getAnswer(1, firstIndex-1);
               			QView.setText(answer[0]);
            		}
            		p.updateFirst(firstIndex, 1);
            		firstIndex++;
                }
        		
                else if(count < 33)
                {
        			int x = r.nextInt(10);
        			if(x < 3)
        			{
        				int depRand = r.nextInt(6);
        				QView.setText(questions.getQuestion(3, depRand));
        				btn_opt1.setText(questions.getAnswer(3, depRand)[0]);
                		btn_opt2.setText(questions.getAnswer(3, depRand)[1]);
        				
        				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        		        // set title
        			    alertDialogBuilder.setTitle("End of week");
        		 
        					// set dialog message
        					alertDialogBuilder.setMessage(p.updateDepend(depRand, 1) + '\n' + p.getMsg())
        						.setCancelable(false)
        						
        						.setNegativeButton("Ok",new DialogInterface.OnClickListener() {
        							public void onClick(DialogInterface dialog,int id) {
        								// if this button is clicked, just close
        								// the dialog box and do nothing
        								dialog.cancel();
        							}
        						});
        		 
        						// create alert dialog
        						AlertDialog alertDialog = alertDialogBuilder.create();
        		 
        						// show it
        						alertDialog.show();
        			}
        			else
        			{
        				int randRand = r.nextInt(34);
        				QView.setText(questions.getQuestion(2, randRand));
        				btn_opt1.setText(questions.getAnswer(2, randRand)[0]);
                		btn_opt2.setText(questions.getAnswer(2, randRand)[1]);
        				
        				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        		        // set title
        			    alertDialogBuilder.setTitle("End of week");
        		 
        					// set dialog message
        					alertDialogBuilder.setMessage(p.updateRan(randRand, 1) + '\n' + p.getMsg())
        						.setCancelable(false)
        						.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
        							public void onClick(DialogInterface dialog,int id) {
        								// if this button is clicked, close
        								// current activity
        								MainActivity.this.finish();
        							}
        						  })
        						/*.setNegativeButton("No",new DialogInterface.OnClickListener() {
        							public void onClick(DialogInterface dialog,int id) {
        								// if this button is clicked, just close
        								// the dialog box and do nothing
        								dialog.cancel();
        							}
        						})*/;
        		 
        						// create alert dialog
        						AlertDialog alertDialog = alertDialogBuilder.create();
        		 
        						// show it
        						alertDialog.show();
        			}
        			count++;
                }
                
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

            btn_ll.addView(btn_opt3, btn_lp);
            btn_opt3.setText(scenario3);
        }
        else{
            //Do nothing
        }
    }

    


}
