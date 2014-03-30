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
    private TextView QView, JobView, gradeScale,energyScale,happyScale;
    
    public Context context = this;
    
    private int moneyAmount;
    private int loanDebt;
    private int gradeBarProgress;
    private int happyBarProgress;
    private int energyBarProgress;
    private int week;
    
    private Player p;
    private String[] answers;
    private String question;
    private Random r;
    private Random r1;
    private Random r2;
    private int counter; 
    private final static int OTHER_SCREEN = 1;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        //Instantiate objects and values
        question="";
        answers = new String[3];
        r = new Random();
        r1 = new Random();
        r2 = new Random();
        counter=1;
        
        p = new Player(5000,100,100,100,12000);
        
        instantiate();
        
        
       
    }
    
    
    
    public void instantiate()
    {
    	getValue();
    	
    	btn_opt1 = (Button) findViewById(R.id.btn_opt1);
    	
    	
        btn_opt2 = (Button) findViewById(R.id.btn_opt2);
       
        
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
        moneyAmountView.setTextSize(35);
        weekView = (TextView) findViewById(R.id.weekView);
        loanAmountView = (TextView) findViewById(R.id.loanView);
        QView = (TextView)findViewById(R.id.situation);
        JobView = (TextView)findViewById(R.id.jobView);
        gradeScale = (TextView)findViewById(R.id.gradeScale);
        energyScale = (TextView)findViewById(R.id.energyScale);
        happyScale = (TextView)findViewById(R.id.happinessScale);
        
        setViews();
        question = p.getQuestions().getQuestion(1, 0);
		answers = p.getQuestions().getAnswer(1, 0);
		btn_opt1.setText(answers[0]);
		btn_opt2.setText(answers[1]);

        btn_opt1.setOnClickListener(new View.OnClickListener() {
        	@Override
            public void onClick(View view) {
        		weeklyUpdate(0);
        		counter++;
                
            }
        });

        btn_opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	weeklyUpdate(1);
        		counter++;
            }
        });
  	 
    }
    
    public void getValue()
    {
    	moneyAmount = p.getCash();
        loanDebt = p.getLoan();
        gradeBarProgress = p.getGrades();
        happyBarProgress = p.getHappy();
        energyBarProgress = p.getEnergy();
        week = p.getWeek();
    }
    public void setViews()
    {
    	loanAmountView.setText("Loans: $" + loanDebt);
    	moneyAmountView.setText("$" + moneyAmount);
    	weekView.setText("Week: " + week);
    	gradeBar.setProgress(gradeBarProgress);
        happyBar.setProgress(happyBarProgress);
        energyBar.setProgress(energyBarProgress);
        gradeScale.setText(gradeBarProgress + "/100");
        energyScale.setText(energyBarProgress + "/100");
        happyScale.setText(happyBarProgress + "/100");
    }
    /**
	 * Gets the question
	 * @param type
	 * 		  1 = First
	 * 		  2 = Random
	 * 		  3 = Dependent
	 * @param index
	 * 		  0 - 4 for First
	 * 		  0 - 31 for Random
	 * 		  0 - 4 for Dependent
	 * @return
	 *      Answer
	 */
    public void weeklyUpdate(int answerIndex)
    {
    	if(counter <5)
    	{
    		
    			question = p.getQuestions().getQuestion(1, counter);
    			answers = p.getQuestions().getAnswer(1, counter);
    			btn_opt1.setText(answers[0]);
    			btn_opt2.setText(answers[1]);
    			//btn_opt3.setText(answers[2]);
    			QView.setText(question);
    			p.updateFirst(counter-1, answerIndex);
    			if(counter == 3)
    			{
    				if(answerIndex == 0)
    				{
    					JobView.setText("Job: $7/hr");
    				}
    				else
    				{
    					JobView.setText("Job: $9/hr");
    				}
    			}
    		
       	}
    	
    	else if(counter<37)
    	{
    		String mess = "";
    		int qType = r.nextInt(2)+2;
    		int qIndex =0;
    		if(qType == 2)
    		{
    			qIndex = r.nextInt(32);
    			mess = p.updateRan(qIndex, answerIndex);
    		}
    		else
    		{
    			qIndex = r.nextInt(5);
    			mess = p.updateDepend(qIndex, answerIndex);
    		}
    		question = p.getQuestions().getQuestion(qType, qIndex);
			answers = p.getQuestions().getAnswer(qType, qIndex);
			btn_opt1.setText(answers[0]);
			btn_opt2.setText(answers[1]);
			//btn_opt3.setText(answers[2]);
			QView.setText(question);
			
			
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
	        alertDialogBuilder.setTitle("End of week");
	        alertDialogBuilder.setMessage(mess + '\n' + p.getMsg()).setCancelable(false)
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
    		// the end of the semester, check the loans.
    	}
    	getValue();
    	setViews();
    	
    	
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
