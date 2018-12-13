package darryl.esteva.com.nutritionistapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
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
