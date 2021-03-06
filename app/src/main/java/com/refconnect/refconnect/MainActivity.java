package com.refconnect.refconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        if(view.getId() == R.id.search_button){

            Button button = (Button) findViewById(R.id.search_button);

            button.setBackgroundDrawable(getResources().getDrawable(R.drawable.mybutton_state));

            Intent intent = new Intent(this, PostActivity.class);
            startActivity(intent);

        }else if(view.getId() == R.id.volunteer_button){

            Button button = (Button) findViewById(R.id.volunteer_button);

            button.setBackgroundDrawable(getResources().getDrawable(R.drawable.mybutton_state));

            Intent intent = new Intent(this, VolunteerSearch.class);
            startActivity(intent);
        }
    }

}
