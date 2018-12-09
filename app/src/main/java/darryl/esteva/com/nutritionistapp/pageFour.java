package darryl.esteva.com.nutritionistapp;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class pageFour extends AppCompatActivity {


    DatabaseHelper myDb;


    TextView bmiTextView;
    Button forUnderweight, forNormalweight, forOverweight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_four);

        myDb = new DatabaseHelper(this);
        bmiTextView = (TextView) findViewById(R.id.bmiTextView);
        forUnderweight = (Button)findViewById(R.id.underweightButton);
        forNormalweight = (Button)findViewById(R.id.normalweightButton);
        forOverweight = (Button)findViewById(R.id.overweightButton);

        showUserBMI();



    }

    public void showUserBMI()
    {
        Cursor res = myDb.getDataOnID();




        while(res.moveToNext()) {
            double bmiOutput = res.getDouble(3);




            if(bmiOutput == 0.0)
            {
                bmiTextView.setText("Please Generate your BMI First");
            }

            else
            {




                String bmiLabel = "";
                //very severely underweight
                if(Double.compare(bmiOutput, 15) <=0) {
                    forUnderweight.setVisibility(View.VISIBLE);
                    bmiLabel = "Very Severely Underweight";
                }
                //severely underweight
                else if(Double.compare(bmiOutput, 15) > 0 && Double.compare(bmiOutput, 16) <=0) {
                    forUnderweight.setVisibility(View.VISIBLE);
                    bmiLabel = "severely underweight";
                }
                //underweight
                else if(Double.compare(bmiOutput, 16) > 0 && Double.compare(bmiOutput, 18.5) <=0) {
                    forUnderweight.setVisibility(View.VISIBLE);
                    bmiLabel = "underweight";
                }

                //normal weight
                else if(Double.compare(bmiOutput, 18.5) > 0  && Double.compare(bmiOutput, 25) <=0) {
                    forNormalweight.setVisibility(View.VISIBLE);
                    bmiLabel = "normal";
                }

                else if(Double.compare(bmiOutput, 25) > 0 && Double.compare(bmiOutput, 30) <=0)
                {
                    forOverweight.setVisibility(View.VISIBLE);
                    bmiLabel = "overweight";
                }

                else if(Double.compare(bmiOutput, 30) > 0 && Double.compare(bmiOutput, 35) <=0)
                {
                    forOverweight.setVisibility(View.VISIBLE);
                    bmiLabel = "Obese class I";
                }

                else if(Double.compare(bmiOutput, 35) > 0 && Double.compare(bmiOutput, 40) <=0)
                {
                    forOverweight.setVisibility(View.VISIBLE);
                    bmiLabel = "Obese class II";
                }

                else
                {
                    forOverweight.setVisibility(View.VISIBLE);
                    bmiLabel = "Obese class III";
                }


                bmiTextView.setText("YOUR BMI IS: " + bmiOutput + "\nYou are " + bmiLabel);
            }





            /*//very severely underweight
            if(Double.compare(bmiOutput, 15) <=0) {
                forUnderweight.setVisibility(View.VISIBLE);
            }
            //severely underweight
            else if(Double.compare(bmiOutput, 15) > 0 && Double.compare(bmiOutput, 16) <=0) {
                forUnderweight.setVisibility(View.VISIBLE);
            }
            //underweight
            else if(Double.compare(bmiOutput, 16) > 0 && Double.compare(bmiOutput, 18.5) <=0) {
                forUnderweight.setVisibility(View.VISIBLE);
            }

            //normal weight
            else if(Double.compare(bmiOutput, 18.5) > 0  && Double.compare(bmiOutput, 25) <=0) {
                forNormalweight.setVisibility(View.VISIBLE);
            }



            else
            {
                forOverweight.setVisibility(View.VISIBLE);
            }*/





    }





    }



}
