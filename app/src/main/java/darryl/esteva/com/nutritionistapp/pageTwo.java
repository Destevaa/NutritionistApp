package darryl.esteva.com.nutritionistapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class pageTwo extends AppCompatActivity {


    //added code
    DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


            setContentView(R.layout.activity_page_two);




        //added code
        myDb = new DatabaseHelper(this);
    }

    public void page3(View v)
    {

       /*Cursor mCursor = myDb.rawQuery("SELECT * FROM USERTABLE" , null);
        Boolean rowExists;

        if (mCursor.moveToFirst())
        {
            // DO SOMETHING WITH CURSOR
            rowExists = true;

        } else
        {
            // I AM EMPTY
            rowExists = false;
        }*/

        Cursor res = myDb.getAllData();
        if(res.getCount() == 0)
        {
            //show message
            //showMessage("Error", "Nothing Found");
            //return;
            //Code for showing next page
            Intent i = null;
            Intent chooser = null;

            //passing into another page
            if(v.getId()==R.id.buttonTwo)
            {
                i = new Intent(this,UserRegistration.class);
                startActivity(i);
            }
        }
        else
        {
            Intent i = null;
            Intent chooser = null;

            //passing into another page
            if(v.getId()==R.id.buttonTwo)
            {
                i = new Intent(this,pageThree.class);
                startActivity(i);
            }
        }


        //show message
        //showMessage("Error", "Nothing Found");
        //return;
        //Code for showing next page
        /*Intent i = null;
        Intent chooser = null;

        //passing into another page
        if(v.getId()==R.id.buttonTwo)
        {
            i = new Intent(this,UserRegistration.class);
            startActivity(i);
        }*/

        /*StringBuffer buffer = new StringBuffer();
        while(res.moveToNext())
        {
            buffer.append("Id: " + res.getString(0) + "\n");
            buffer.append("Name: " + res.getString(1) + "\n");
            buffer.append("Username: " + res.getString(2) + "\n");
            buffer.append("BMI: " + res.getString(3) + "\n\n");
        }*/

        //Show all data
        //showMessage("Data ",buffer.toString());


        //Code for showing next page
        /*Intent i = null;
        Intent chooser = null;

        //passing into another page
        if(v.getId()==R.id.buttonTwo)
        {
            i = new Intent(this,UserRegistration.class);
            startActivity(i);
        }*/

    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }


    public void page4(View v)
    {

        Intent i = null;
        Intent chooser = null;

        //passing into another page
        if(v.getId()==R.id.buttonFour)
        {
            i = new Intent(this,pageFour.class);
            startActivity(i);
        }

    }


}
