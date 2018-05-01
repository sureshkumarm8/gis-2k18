package com.udacity.googleindiascholarships.stories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.udacity.googleindiascholarships.R;
import com.udacity.googleindiascholarships.stories.Utils.PersonDBHelper;
import com.udacity.googleindiascholarships.stories.model.Person;

public class UpdateRecordActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mURLEditText;
    private EditText mTitleEditText;
    private EditText mImageEditText;
    private Button mUpdateBtn;

    private PersonDBHelper dbHelper;
    private long receivedPersonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);

        //init
        mNameEditText = (EditText)findViewById(R.id.userNameUpdate);
        mURLEditText = (EditText)findViewById(R.id.uURLUpdate);
        mTitleEditText = (EditText)findViewById(R.id.userTitleUpdate);
        mImageEditText = (EditText)findViewById(R.id.userProfileImageLinkUpdate);
        mUpdateBtn = (Button)findViewById(R.id.updateUserButton);

        dbHelper = new PersonDBHelper(this);

        try {
            //get intent to get person id
            receivedPersonId = getIntent().getLongExtra("USER_ID", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /***populate user data before update***/
        Person queriedPerson = dbHelper.getPerson(receivedPersonId);
        //set field to this user data
        mNameEditText.setText(queriedPerson.getName());
        mURLEditText.setText(queriedPerson.getStroyurl());
        mTitleEditText.setText(queriedPerson.getTitle());
        mImageEditText.setText(queriedPerson.getImage());



        //listen to add button click to update
        mUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call the save person method
                updatePerson();
            }
        });





    }

    private void updatePerson(){
        String name = mNameEditText.getText().toString().trim();
        String age = mURLEditText.getText().toString().trim();
        String occupation = mTitleEditText.getText().toString().trim();
        String image = mImageEditText.getText().toString().trim();


        if(name.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter a name", Toast.LENGTH_SHORT).show();
        }

        if(age.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter a URL", Toast.LENGTH_SHORT).show();
        }

        if(occupation.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter a title", Toast.LENGTH_SHORT).show();
        }

        if(image.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter an image link", Toast.LENGTH_SHORT).show();
        }

        //create updated person
        Person updatedPerson = new Person(name, age, occupation, image);

        //call dbhelper update
        dbHelper.updatePersonRecord(receivedPersonId, this, updatedPerson);

        //finally redirect back home
        // NOTE you can implement an sqlite callback then redirect on success delete
        goBackHome();

    }

    private void goBackHome(){
        startActivity(new Intent(this, MainActivitySto.class));
    }
}
