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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_four);

        myDb = new DatabaseHelper(this);
        bmiTextView = (TextView) findViewById(R.id.bmiTextView);



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
                bmiTextView.setText("YOUR BMI IS: " + bmiOutput);
            }



        }





    }



}
