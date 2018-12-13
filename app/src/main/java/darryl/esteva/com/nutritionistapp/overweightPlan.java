package darryl.esteva.com.nutritionistapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class overweightPlan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overweight_plan);
    }

    public void monday(View v)
    {

        Intent i = null;
        Intent chooser = null;

        //passing into another page
        if(v.getId()==R.id.mondayImageButton)
        {
            i = new Intent(this,mondayOverweight.class);
            startActivity(i);
        }

    }

    public void tuesday(View v)
    {

        Intent i = null;
        Intent chooser = null;

        //passing into another page
        if(v.getId()==R.id.tuesdayImageButton)
        {
            i = new Intent(this,tuesdayOverweight.class);
            startActivity(i);
        }

    }

    public void wednesday(View v)
    {

        Intent i = null;
        Intent chooser = null;

        //passing into another page
        if(v.getId()==R.id.wednesdayImageButton)
        {
            i = new Intent(this,wednesdayOverweight.class);
            startActivity(i);
        }

    }

    public void thursday(View v)
    {

        Intent i = null;
        Intent chooser = null;

        //passing into another page
        if(v.getId()==R.id.thursdayImageButton)
        {
            i = new Intent(this,thursdayOverweight.class);
            startActivity(i);
        }

    }

    public void friday(View v)
    {

        Intent i = null;
        Intent chooser = null;

        //passing into another page
        if(v.getId()==R.id.fridayImageButton)
        {
            i = new Intent(this,fridayOverweight.class);
            startActivity(i);
        }

    }

    public void saturday(View v)
    {

        Intent i = null;
        Intent chooser = null;

        //passing into another page
        if(v.getId()==R.id.saturdayImageButton)
        {
            i = new Intent(this,saturdayOverweight.class);
            startActivity(i);
        }

    }

    public void sunday(View v)
    {

        Intent i = null;
        Intent chooser = null;

        //passing into another page
        if(v.getId()==R.id.sundayImageButton)
        {
            i = new Intent(this,sundayOverweight.class);
            startActivity(i);
        }

    }

    public void goToHome(View v)
    {
        //Original Code
        Intent i = null;
        Intent chooser = null;

        //passing into another page
        if(v.getId()==R.id.homeImageButton)
        {
            i = new Intent(this,pageTwo.class);
            startActivity(i);
        }
    }

    public void goToAbout(View v)
    {
        //Original Code
        Intent i = null;
        Intent chooser = null;

        //passing into another page
        if(v.getId()==R.id.aboutImageButton)
        {
            i = new Intent(this,aboutUs.class);
            startActivity(i);
        }
    }

    public void goToSettings(View v)
    {
        //Original Code
        Intent i = null;
        Intent chooser = null;

        //passing into another page
        if(v.getId()==R.id.settingsImageButton)
        {
            i = new Intent(this,settings.class);
            startActivity(i);
        }
    }
}
