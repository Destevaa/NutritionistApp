package darryl.esteva.com.nutritionistapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class pageTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_two);
    }

    public void page3(View v)
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
