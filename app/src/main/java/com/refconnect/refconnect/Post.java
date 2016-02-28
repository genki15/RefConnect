package com.refconnect.refconnect;

import java.util.Date;

/**
 * Created by Nodirjon on 2/27/2016.
 */
public class Post {
    private String name;
    private String location;
    private String keywords;
    private String spokenLanguages;
    private Date postPeriod;

    public Post() {}

    public Post(String name,
                String location,
                String keywords,
                String spokenLanguages,
                Date postPeriod) {
        this.name = name;
        this.location = location;
        this.keywords = keywords;
        this.spokenLanguages = spokenLanguages;
        this.postPeriod = postPeriod;
    }

    public Date getPostPeriod() {
        return postPeriod;
    }

    public String getSpokenLanguages() {
        return spokenLanguages;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
