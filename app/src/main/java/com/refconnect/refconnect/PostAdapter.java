package com.refconnect.refconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Louis on 28/02/2016.
 */
public class PostAdapter extends ArrayAdapter<Post>{

    public PostAdapter(Context context, Post[] values) {
        super(context, R.layout.row_layout, values);
    }
    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        LayoutInflater theInflater = LayoutInflater.from(getContext());
        View theView = theInflater.inflate(R.layout.row_layout, parent, false);
        Post post = getItem(position);
        TextView tVName = (TextView) theView.findViewById(R.id.name);
        TextView tVLocation = (TextView) theView.findViewById(R.id.location);
        tVName.append(post.getName());
        tVLocation.append(post.getLocation());
        return theView;
    }
}

