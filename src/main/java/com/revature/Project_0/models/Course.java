package com.revature.Project_0.models;

public class Course {

    private int id;
    private String courseName, shortHandName, courseDetail;
    private boolean courseOpen, cancelWindow;

    public Course(String cn, String shnd, String detail, boolean open, boolean cnl){
        this.courseName = cn;
        this.shortHandName = shnd;
        this.courseDetail = detail;
        this.courseOpen = open;
        this.cancelWindow = cnl;

    }

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
