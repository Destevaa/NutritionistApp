package darryl.esteva.com.nutritionistapp;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    //added code
    DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //added code
        myDb = new DatabaseHelper(this);
    }


    public void page2(View v)
    {
        //added  code
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
            if(v.getId()==R.id.buttonOne)
            {
                i = new Intent(this,UserRegistration.class);
                startActivity(i);
            }
        }
        else
        {


            //Original Code
            Intent i = null;
            Intent chooser = null;

            //passing into another page
            if(v.getId()==R.id.buttonOne)
            {
                i = new Intent(this,pageTwo.class);
                startActivity(i);
            }


            /*Intent i = null;
            Intent chooser = null;

            //passing into another page
            if(v.getId()==R.id.buttonTwo)
            {
                i = new Intent(this,pageThree.class);
                startActivity(i);
            }*/
        }


        //Original Code
        /*Intent i = null;
        Intent chooser = null;

        //passing into another page
        if(v.getId()==R.id.buttonOne)
        {
            i = new Intent(this,pageTwo.class);
            startActivity(i);
        }*/

    }


}
