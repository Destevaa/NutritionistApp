package darryl.esteva.com.nutritionistapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserRegistration extends AppCompatActivity {

    DatabaseHelper myDb;
    //EditText editName, editUsername,  editTextId;
    EditText editName, editUsername, editBmi, editTextId, editTextBmiValue;

    Button btnAddData;
    Button btnviewAll;
    Button btnviewUpdate;
    Button btnDelete;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



            setContentView(R.layout.activity_user_registration);

        myDb = new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.editText_name);
        editUsername = (EditText)findViewById(R.id.editText_Username);
        editBmi = (EditText)findViewById(R.id.editText_Bmi);
        //editBmi = "N/A";

        editTextId = (EditText)findViewById(R.id.editText_id);
        btnAddData = (Button)findViewById(R.id.editText_add);
        btnviewAll = (Button)findViewById(R.id.button_viewAll);
        btnviewUpdate = (Button)findViewById(R.id.button_update);
        btnDelete = (Button)findViewById(R.id.button_delete);

        AddData();
        viewAll();
        //updateData();
        DeleteData();




    }

    public void DeleteData(){
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(editTextId.getText().toString());

                        if(deletedRows > 0){
                            Toast.makeText(UserRegistration.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        }

                        else
                        {
                            Toast.makeText(UserRegistration.this, "Data not Deleted", Toast.LENGTH_LONG).show();
                        }
                    }
                }

        );
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


    public void AddData()
    {


            btnAddData.setOnClickListener(
                    new View.OnClickListener(){
                        @Override
                        public void onClick(View v)
                        {
                            if( TextUtils.isEmpty(editName.getText())){
                                /**
                                 *   You can Toast a message here that the Username is Empty
                                 **/
                                Toast.makeText(UserRegistration.this, "Name is empty", Toast.LENGTH_LONG).show();

                                editName.setError( "First name is required!" );

                            }

                            else if ( TextUtils.isEmpty(editUsername.getText())){
                                /**
                                 *   You can Toast a message here that the Username is Empty
                                 **/
                                Toast.makeText(UserRegistration.this, "Username is empty", Toast.LENGTH_LONG).show();

                                editUsername.setError( "User name is required!" );

                            }




                            else
                            {
                                boolean isInserted = myDb.insertData(
                                        editName.getText().toString(),
                                        editUsername.getText().toString(),
                                        "0"

                                );

                                if(isInserted == true)
                                {


                                    Toast.makeText(UserRegistration.this, "Data Inserted", Toast.LENGTH_LONG).show();
                                    //editTextBmiValue.setText(editBmi);

                                    pageRedirect(v);






                                }

                                else
                                {
                                    Toast.makeText(UserRegistration.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                                }
                            }



                        }
                    }


            );




    }


    public void pageRedirect(View v) {
        //Code for showing next page
        Intent i = null;
        Intent chooser = null;

        //passing into another page

            i = new Intent(this,pageTwo.class);
            startActivity(i);


    }





    public void viewAll()
    {
        btnviewAll.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0)
                        {
                            //show message
                            showMessage("Error", "Nothing Found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext())
                        {
                            buffer.append("Id: " + res.getString(0) + "\n");
                            buffer.append("Name: " + res.getString(1) + "\n");
                            buffer.append("Username: " + res.getString(2) + "\n");
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
