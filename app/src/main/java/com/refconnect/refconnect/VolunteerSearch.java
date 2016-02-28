package com.refconnect.refconnect;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by genki on 16/02/27.
 */
public class VolunteerSearch extends AppCompatActivity{

    private double lat = 35.670930;
    private double lng = 139.50249;
    private ImageView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volunteer_search);
/*
        map = (ImageView) findViewById(R.id.map);

        String imageUrl = "http://maps.googleapis.com/maps/api/staticmap?center=" + lat + "," + lng
                + "&zoom=10"
                + "&size=640x640"
                + "&scale=1"
                + "&key=AIzaSyDUKe-EJql0HVzkwMvjXvu5B6CmCSmHpp4";

        try {
            URL url = new URL(imageUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new LoadImage().execute(imageUrl);
 */
    }
/*
    private class LoadImage extends AsyncTask<String, String, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        protected Bitmap doInBackground(String... args) {

            Bitmap bitmap = null;
            if(args.length == 1){
                Log.i("doInBack 1", "length = 1 ");

                try {
                    bitmap = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return bitmap;
        }
        protected void onPostExecute(Bitmap image) {
            if(image != null){
                map.setImageBitmap(image);

            }
        }
    }

    */
}
