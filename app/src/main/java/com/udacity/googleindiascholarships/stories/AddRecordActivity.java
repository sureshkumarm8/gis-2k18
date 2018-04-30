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

public class AddRecordActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mURLEditText;
    private EditText mTitleEditText;
    private EditText mImageEditText;
    private Button mAddBtn;

    private PersonDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        //init
        mNameEditText = (EditText)findViewById(R.id.userName);
        mURLEditText = (EditText)findViewById(R.id.userAge);
        mTitleEditText = (EditText)findViewById(R.id.userOccupation);
        mImageEditText = (EditText)findViewById(R.id.userProfileImageLink);
        mAddBtn = (Button)findViewById(R.id.addNewUserButton);

        //listen to add button click
        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call the save person method
                savePerson();
            }
        });

    }

    private void savePerson(){
        String name = mNameEditText.getText().toString().trim();
        String age = mURLEditText.getText().toString().trim();
        String occupation = mTitleEditText.getText().toString().trim();
        String image = mImageEditText.getText().toString().trim();
        dbHelper = new PersonDBHelper(this);

        if(name.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter a name", Toast.LENGTH_SHORT).show();
        }

        if(age.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter an URL", Toast.LENGTH_SHORT).show();
        }

        if(occupation.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter a title", Toast.LENGTH_SHORT).show();
        }

        if(image.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter an image link", Toast.LENGTH_SHORT).show();
        }

        //create new person
        Person person = new Person(name, age, occupation, image);
        dbHelper.saveNewPerson(person);

        //finally redirect back home
        // NOTE you can implement an sqlite callback then redirect on success delete
        goBackHome();

    }

    private void goBackHome(){
        startActivity(new Intent(AddRecordActivity.this, MainActivitySto.class));
    }
}
