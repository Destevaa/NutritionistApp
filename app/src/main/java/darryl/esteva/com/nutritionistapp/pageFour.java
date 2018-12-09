package darryl.esteva.com.nutritionistapp;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class pageFour extends AppCompatActivity {


    DatabaseHelper myDb;
    Button getBMI;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_four);

        myDb = new DatabaseHelper(this);

        getBMI = (Button)findViewById(R.id.retrieveBMI);

        viewBMIbyID();
    }



    public void viewBMIbyID()
    {
        getBMI.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Cursor res = myDb.getDataOnID();
                        if(res.getCount() == 0)
                        {
                            //show message
                            showMessage("Error", "Nothing Found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext())
                        {
                            /*buffer.append("Id: " + res.getString(0) + "\n");
                            buffer.append("Name: " + res.getString(1) + "\n");
                            buffer.append("Username: " + res.getString(2) + "\n");*/
                            buffer.append("BMI: " + res.getString(3) + "\n\n");
                        }

                        //Show all data
                        showMessage("Data ",buffer.toString());



                    }
                }


        );
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }

}
