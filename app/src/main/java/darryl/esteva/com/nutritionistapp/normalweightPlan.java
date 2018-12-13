package darryl.esteva.com.nutritionistapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class normalweightPlan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normalweight_plan);
    }


    public void monday(View v)
    {

        Intent i = null;
        Intent chooser = null;

        //passing into another page
        if(v.getId()==R.id.mondayImageButton)
        {
            i = new Intent(this,mondayNormalweight.class);
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
            i = new Intent(this,tuesdayNormalweight.class);
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
            i = new Intent(this,wednesdayNormalweight.class);
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
            i = new Intent(this,thursdayNormalweight.class);
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
            i = new Intent(this,fridayNormalweight.class);
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
            i = new Intent(this,saturdayNormalweight.class);
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
            i = new Intent(this,sundayNormalweight.class);
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
