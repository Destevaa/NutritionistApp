package darryl.esteva.com.nutritionistapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class pageThree extends AppCompatActivity {

    DatabaseHelper myDb;

    EditText height, weight;
    TextView result;
    Button calculate;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_three);

        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        calculate = (Button) findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                calculateBMI();
            }
        });


        myDb = new DatabaseHelper(this);

    }


    private void calculateBMI()
    {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if(heightStr != null && !"".equals(heightStr) && weightStr != null && !"".equals(weightStr))
        {
            float heightValue = Float.parseFloat(heightStr);
            float weightValue = Float.parseFloat(weightStr);



            final float bmi = weightValue / heightValue / heightValue;

            float number = bmi;
            Float floatInstance = new Float(number);
            final String numberAsString = floatInstance.toString();

            displayBMI(bmi);


            boolean isUpdate = myDb.updateData("1", numberAsString
            );

            if(isUpdate == true)
            {
                Toast.makeText(pageThree.this, "Data Updated", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(pageThree.this, "Data not Updated", Toast.LENGTH_LONG).show();
            }
                            }






            //UPDATE BMI CODE
            /*calculate.setOnClickListener(
                                new View.OnClickListener(){
                                    @Override
                                    public void onClick(View v)
                                    {

                            boolean isUpdate = myDb.updateData("1", "123"
                            );

                            if(isUpdate == true)
                            {
                                Toast.makeText(pageThree.this, "Data Updated", Toast.LENGTH_LONG).show();
                            }

                            else
                            {
                                Toast.makeText(pageThree.this, "Data not Updated", Toast.LENGTH_LONG).show();
                            }


                        }
                    }

            );*/

            //END

        }





    private void displayBMI(float bmi)
    {
        String bmiLabel = "";

        if(Float.compare(bmi, 15f) <=0)
        {
            bmiLabel = "Very Severely Underweight";
        }

        else if(Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <=0)
        {
            bmiLabel = "severely underweight";

        }

        else if(Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <=0)
        {
            bmiLabel = "underweight";
        }

        else if(Float.compare(bmi, 18.5f) > 0  && Float.compare(bmi, 25f) <=0)
        {
            bmiLabel = "normal";
        }

        else if(Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <=0)
        {
            bmiLabel = "overweight";
        }

        else if(Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <=0)
        {
            bmiLabel = "Obese class I";
        }

        else if(Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <=0)
        {
            bmiLabel = "Obese class II";
        }

        else
        {
            bmiLabel = "Obese class III";
        }

        bmiLabel = bmi + "\n" + bmiLabel;
        result.setText(bmiLabel);

    }

    /*public void updateData()
    {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v)
                    {
                        boolean isUpdate = myDb.updateData("1", editName.getText().toString(),
                                editUsername.getText().toString(), editBmi.getText().toString()

                        );

                        if(isUpdate == true)
                        {
                            Toast.makeText(UserRegistration.this, "Data Updated", Toast.LENGTH_LONG).show();
                        }

                        else
                        {
                            Toast.makeText(UserRegistration.this, "Data not Updated", Toast.LENGTH_LONG).show();
                        }


                    }
                }

        );
    }*/





}
