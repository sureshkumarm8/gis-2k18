package com.udacity.googleindiascholarships.stories.model;

/**
 * Created by Ronsoft on 11/13/2017.
 */

public class Person {

    private long id;
    private String name;
    private String stroyurl;
    private String title;
    private String image;

    public Person() {
    }

    public Person(String name, String stroyurl, String title, String image) {
        this.name = name;
        this.stroyurl = stroyurl;
        this.title = title;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStroyurl() {
        return stroyurl;
    }

    public void setStroyurl(String stroyurl) {
        this.stroyurl = stroyurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
