package com.refconnect.refconnect;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

        name = (EditText)findViewById(R.id.name1);
        location = (EditText)findViewById(R.id.location);
        keywords = (EditText)findViewById(R.id.keywords);
        language = (EditText)findViewById(R.id.language);
        deadline = (EditText)findViewById(R.id.deadline);

        final Button button = (Button) findViewById(R.id.post_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(view.getId() == R.id.post_button) {

                    try {
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        date = formatter.parse(getText(deadline));
                    } catch (ParseException e) {
                        e.printStackTrace();
                        System.out.println("ParseException caught, wrong date format");
                        date= null;
                    }

                    if(getText(name)!="" && getText(location)!=""&& getText(keywords)!="" && getText(language)!="") {
                        post = new Post(getText(name), getText(location), getText(keywords), getText(language), date);
                        button.setBackgroundDrawable(getResources().getDrawable(R.drawable.mybutton2_state));
                        dbRef.push().setValue(post);
                    }

                    AlertDialog alertDialog = new AlertDialog.Builder(
                            PostActivity.this).create();
                    // Setting Dialog Title
                    alertDialog.setTitle("Thank you");
                    // Setting Dialog Message
                    alertDialog.setMessage("Thank you for your entry!");
                    // Setting Icon to Dialog
                    alertDialog.setIcon(R.mipmap.logo);
                    // Setting OK Button
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Write your code here to execute after dialog closed
                            //OLD --> Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                            //link back to start
                            Intent intent = new Intent(PostActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    // Showing Alert Message
                    alertDialog.show();
                }}
                    });
}
    public String getText(EditText eT)
    {
       return eT.getText().toString();
    }

}
