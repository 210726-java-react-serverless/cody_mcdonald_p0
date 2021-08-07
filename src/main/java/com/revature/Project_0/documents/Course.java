package com.revature.Project_0.documents;

import java.util.Date;

public class Course {

    private int id;
    private String courseName, courseDetail;
    private Date openDate = new Date();
    private Date closeDate = new Date();


    public Course(String cn, String detail){this.courseName = cn;this.courseDetail = detail;}

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

    public String getCourseDetail() {
        return courseDetail;
    }

    public void setCourseDetail(String courseDetail) {
        this.courseDetail = courseDetail;
    }

    public Date getOpenDate() { return openDate; }

    public void setOpenDate(Date openDate) { this.openDate = openDate; }

    public Date getCloseDate() { return closeDate;}

    public void setCloseDate(Date closeDate) {this.closeDate = closeDate;}
}
