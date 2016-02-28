package com.refconnect.refconnect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PostActivity extends AppCompatActivity {

    private Firebase dbRef;
    private Post post;
    private EditText name, location, keywords, language, deadline;
    private Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refugee_post);

        Firebase.setAndroidContext(this);

        dbRef = new Firebase("https://refconnect.firebaseio.com/");

        name = (EditText)findViewById(R.id.name);
        location = (EditText)findViewById(R.id.location);
        keywords = (EditText)findViewById(R.id.keywords);
        language = (EditText)findViewById(R.id.language);
        deadline = (EditText)findViewById(R.id.deadline);
        try {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        date = formatter.parse(deadline.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        post = new Post(name.getText().toString(), location.getText().toString(), keywords.getText().toString(), language.getText().toString(),date);
        final Button button = (Button) findViewById(R.id.post_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(view.getId() == R.id.post_button) {
                    button.setBackgroundDrawable(getResources().getDrawable(R.drawable.mybutton2_state));
                    dbRef.push().setValue(post);
                }}
                    });

}}
