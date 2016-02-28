package com.refconnect.refconnect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.client.Firebase;

import java.util.Date;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refugee_post);

        Firebase.setAndroidContext(this);

        Firebase dbRef = new Firebase("https://refconnect.firebaseio.com/");

        Firebase postRef = dbRef.child("post");
        Post post = new Post("first post", "london", "documents", "arabic", new Date());
        postRef.setValue(post);
    }
}
