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

    EditText height, weight, feet, inches;
    TextView result;
    Button calculate;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_three);


        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        calculate = (Button) findViewById(R.id.calculate);

        feet = (EditText) findViewById(R.id.feetEditText);
        inches = (EditText) findViewById(R.id.inchesEditText);



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


    /*private void calculateBMI()
    {
        String feetStr = feet.getText().toString();
        String inchesStr = inches.getText().toString();

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
    }*/
    private void calculateBMI()
    {
        String feetStr = feet.getText().toString();
        String inchesStr = inches.getText().toString();

        //String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if(feetStr != null && !"".equals(feetStr) && inchesStr != null && !"".equals(inchesStr) && weightStr != null && !"".equals(weightStr))
        {
            double feetValue = Double.parseDouble(feetStr);
            double inchesValue = Double.parseDouble(inchesStr);

            //float heightValue = Float.parseFloat(heightStr);
            double weightValue = Double.parseDouble(weightStr);

            double feetValueToMeter =  feetValue / 3.2808;

            double inchesValueToMeter =  inchesValue / 39.37;

            double feetAndInchesConvertedToMeter = feetValueToMeter + inchesValueToMeter;

            final double bmi = weightValue / feetAndInchesConvertedToMeter / feetAndInchesConvertedToMeter;


            double number = bmi;
            Double aDoubleInstance = new Double(number);
            final String numberAsString = aDoubleInstance.toString();

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







    private void displayBMI(double bmi)
    {
        String bmiLabel = "";

        if(Double.compare(bmi, 15) <=0)
        {
            bmiLabel = "Very Severely Underweight";
        }

        else if(Double.compare(bmi, 15) > 0 && Double.compare(bmi, 16) <=0)
        {
            bmiLabel = "severely underweight";

        }

        else if(Double.compare(bmi, 16) > 0 && Double.compare(bmi, 18.5) <=0)
        {
            bmiLabel = "underweight";
        }

        else if(Double.compare(bmi, 18.5) > 0  && Double.compare(bmi, 25) <=0)
        {
            bmiLabel = "normal";
        }

        else if(Double.compare(bmi, 25) > 0 && Double.compare(bmi, 30) <=0)
        {
            bmiLabel = "overweight";
        }

        else if(Double.compare(bmi, 30) > 0 && Double.compare(bmi, 35) <=0)
        {
            bmiLabel = "Obese class I";
        }

        else if(Double.compare(bmi, 35) > 0 && Double.compare(bmi, 40) <=0)
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
