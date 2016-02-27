package com.refconnect.refconnect;

import java.util.Date;

/**
 * Created by Nodirjon on 2/27/2016.
 */
public class Post {
    private String name;
    private String location;
    private String[] keywords;
    private String[] spokenLanguages;
    private Date postPeriod;

    public Post(Date postPeriod, String[] spokenLanguages, String[] keywords, String location, String name) {
        this.postPeriod = postPeriod;
        this.spokenLanguages = spokenLanguages;
        this.keywords = keywords;
        this.location = location;
        this.name = name;
    }

    public Date getPostPeriod() {
        return postPeriod;
    }

    public String[] getSpokenLanguages() {
        return spokenLanguages;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
