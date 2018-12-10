package darryl.esteva.com.nutritionistapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class pageFour extends AppCompatActivity {


    DatabaseHelper myDb;


    TextView bmiTextView, recommendTextView;
    Button forUnderweight, forNormalweight, forOverweight;
    ImageView underweightImage, normalweightImage, overweightImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_four);

        myDb = new DatabaseHelper(this);
        bmiTextView = (TextView) findViewById(R.id.bmiTextView);
        recommendTextView = (TextView) findViewById(R.id.recTextView);
        forUnderweight = (Button)findViewById(R.id.underweightButton);
        forNormalweight = (Button)findViewById(R.id.normalweightButton);
        forOverweight = (Button)findViewById(R.id.overweightButton);

        underweightImage =(ImageView)findViewById(R.id.underweightImage);
        normalweightImage =(ImageView)findViewById(R.id.normalweightImage);
        overweightImage =(ImageView)findViewById(R.id.overweightImage);

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
                    underweightImage.setVisibility(View.VISIBLE);
                    bmiLabel = "Very Severely Underweight";
                }
                //severely underweight
                else if(Double.compare(bmiOutput, 15) > 0 && Double.compare(bmiOutput, 16) <=0) {
                    forUnderweight.setVisibility(View.VISIBLE);
                    underweightImage.setVisibility(View.VISIBLE);
                    bmiLabel = "Severely Underweight";
                }
                //underweight
                else if(Double.compare(bmiOutput, 16) > 0 && Double.compare(bmiOutput, 18.5) <=0) {
                    forUnderweight.setVisibility(View.VISIBLE);
                    underweightImage.setVisibility(View.VISIBLE);
                    bmiLabel = "Underweight";
                }

                //normal weight
                else if(Double.compare(bmiOutput, 18.5) > 0  && Double.compare(bmiOutput, 25) <=0) {
                    forNormalweight.setVisibility(View.VISIBLE);
                    normalweightImage.setVisibility(View.VISIBLE);
                    bmiLabel = "Normal Weight";
                }

                else if(Double.compare(bmiOutput, 25) > 0 && Double.compare(bmiOutput, 30) <=0)
                {
                    forOverweight.setVisibility(View.VISIBLE);
                    overweightImage.setVisibility(View.VISIBLE);
                    bmiLabel = "Overweight";
                }

                else if(Double.compare(bmiOutput, 30) > 0 && Double.compare(bmiOutput, 35) <=0)
                {
                    forOverweight.setVisibility(View.VISIBLE);
                    overweightImage.setVisibility(View.VISIBLE);
                    bmiLabel = "Obese I";
                }

                else if(Double.compare(bmiOutput, 35) > 0 && Double.compare(bmiOutput, 40) <=0)
                {
                    forOverweight.setVisibility(View.VISIBLE);
                    overweightImage.setVisibility(View.VISIBLE);
                    bmiLabel = "Obese II";
                }

                else
                {
                    forOverweight.setVisibility(View.VISIBLE);
                    overweightImage.setVisibility(View.VISIBLE);
                    bmiLabel = "Obese III";
                }


                bmiTextView.setText("Your BMI is " + bmiOutput + "\nYou are in the " + bmiLabel + " class");


                recommendTextView.setText("Our Recommended Diet Plan for you is \nThe " + bmiLabel + " Diet Plan" );
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

    public void underweightPlanCall(View v)
    {

        Intent i = null;
        Intent chooser = null;

        //passing into another page
        if(v.getId()==R.id.underweightButton)
        {
            i = new Intent(this,underweightPlan.class);
            startActivity(i);
        }

    }

    public void normalweightPlanCall(View v)
    {

        Intent i = null;
        Intent chooser = null;

        //passing into another page
        if(v.getId()==R.id.normalweightButton)
        {
            i = new Intent(this,normalweightPlan.class);
            startActivity(i);
        }

    }


    public void overweightPlanCall(View v)
    {

        Intent i = null;
        Intent chooser = null;

        //passing into another page
        if(v.getId()==R.id.overweightButton)
        {
            i = new Intent(this,overweightPlan.class);
            startActivity(i);
        }

    }



}
