package com.revature.Project_0.documents;


import java.util.Objects;

public class Course {


    private String id, courseName, courseAbbreviation, courseDetail;
    private boolean isOpen;

    public Course(){ super(); }

    public Course(String cn, String cAbv, String detail, boolean open) {
        this.courseName = cn;
        this.courseAbbreviation = cAbv;
        this.courseDetail = detail;
        this.isOpen = open;
    }

    public Course(String id, String cn, String cAbv, String detail){
        this.id = id;
        this.courseName = cn;
        this.courseAbbreviation = cAbv;
        this.courseDetail = detail;
    }

    public Course(String id, String cn, String cAbv, String detail, boolean open){
        this.id = id;
        this.courseName = cn;
        this.courseAbbreviation = cAbv;
        this.courseDetail = detail;
        this.isOpen = open;
    }


    // Setters and getters
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

    public void setId(String id) { this.id = id; }

    public String getCourseAbbreviation() { return courseAbbreviation; }

    public void setCourseAbbreviation(String courseAbbreviation) { this.courseAbbreviation = courseAbbreviation; }

    public boolean isOpen() { return isOpen; }

    public void setOpen(boolean open) { isOpen = open; }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, courseAbbreviation, courseDetail, isOpen);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
