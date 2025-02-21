package com.springmvc.pmvc.beans;


public class Course 
{
    int id;
    String name;
    String duration;
    
    public Course() {}
    
    public Course(int id, String name, String duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
}