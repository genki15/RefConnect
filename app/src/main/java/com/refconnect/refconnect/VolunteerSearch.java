package com.refconnect.refconnect;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
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
    private Post[] postArray;
    private Button srchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volunteer_search);
        Firebase.setAndroidContext(this);
        dbRef = new Firebase("https://refconnect.firebaseio.com/");
        Query queryRef = dbRef.orderByChild("name");

        listOfPosts=new ArrayList<Post>();
        srchBtn=(Button) findViewById(R.id.SearchButton);

        srchBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                EditText editTextLocation = (EditText)findViewById(R.id.LocationTextField);
                EditText editTextKeyW = (EditText)findViewById(R.id.KeyWordsTextField);
                postArray = new Post[listOfPosts.size()];

                for(Post posts : listOfPosts) {
//                    if (posts.getKeywords() == editTextKeyW.getText().toString()
//                            && posts.getLocation() == editTextLocation.getText().toString()) {

                        for (int i = 0; i < listOfPosts.size(); i++) {

                            postArray[i] = listOfPosts.get(i);
                        }

                        listView = (ListView) findViewById(R.id.listView);
//                    }
                    ListAdapter adapter = new PostAdapter(VolunteerSearch.this, postArray);

                    listView.setAdapter(adapter);
                }
            }
        });

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
