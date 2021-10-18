package com.example.springbootmongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

//not @Entity for relational db
//@Document is for non-relational db
@Document
public class User {

    @Id
    private String id;


    @Indexed(unique = true)
    private String username;

    private String password;

    //obtained from UserProfile model - embedded file - document inside document - embeds userprofile in user
    private UserProfile userProfile;

    //create a reference document/collection
    @DBRef //these reference collections will show up in terminal: db.user.find().pretty()
    private List<Course> courses;

    public User(){}

    public List<Course> getCourses(){
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public UserProfile getUserProfile(){
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile){
        this.userProfile = userProfile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    //not encrypted right now, so not secure => displays password in plain text when db.user.find().pretty()
    //needs passwordencoder
    public void setPassword(String password) {
        this.password = password;
    }
}
