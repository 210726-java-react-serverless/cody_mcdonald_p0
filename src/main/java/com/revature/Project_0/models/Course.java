package com.revature.Project_0.models;

import java.util.Date;

public class Course {

    private int id;
    private String courseName, shortHandName, courseDetail;
    private boolean courseOpen= true, cancelWindow = true;
    //A course is set to open when it is created
    //Probably not a good idea if this is a new application being applied to an existing campus
    // mid-semester or a year-round campus (such as online campuses)
    Date openDate = new Date();
    Date closeDate = new Date();


    public Course(String cn, String abbreviation, String detail){
        this.courseName = cn;
        this.shortHandName = abbreviation;
        this.courseDetail = detail;
    }
    //TODO base course open/close on dates instead of booleans that must be manually updated

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getShortHandName() {
        return shortHandName;
    }

    public void setShortHandName(String shortHandName) {
        this.shortHandName = shortHandName;
    }

    public String getCourseDetail() {
        return courseDetail;
    }

    public void setCourseDetail(String courseDetail) {
        this.courseDetail = courseDetail;
    }

    public boolean isCourseOpen() {
        return courseOpen;
    }

    public void setCourseOpen(boolean courseOpen) {
        this.courseOpen = courseOpen;
    }

    public boolean isCancelWindow() {
        return cancelWindow;
    }

    public void setCancelWindow(boolean cancelWindow) {
        this.cancelWindow = cancelWindow;
    }
}
