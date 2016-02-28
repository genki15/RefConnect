package com.refconnect.refconnect;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
/**
 * Created by genki on 16/02/27.
 */
public class VolunteerSearch extends AppCompatActivity{
    private double lat = 35.670930;
    private double lng = 139.50249;
    private ImageView map;
    private Firebase dbRef;
    private ArrayList<Post> listOfPosts;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volunteer_search);
        Firebase.setAndroidContext(this);
        dbRef = new Firebase("https://refconnect.firebaseio.com/");
        Query queryRef = dbRef.orderByChild("name");

        listOfPosts=new ArrayList<Post>();

        listView = (ListView) findViewById(R.id.listView);

        /*ArrayAdapter<Post> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listOfPosts);*/

        listView.setAdapter(adapter);

        queryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChild) {
                Post post = snapshot.getValue(Post.class);
                listOfPosts.add(post);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });


    }

}
