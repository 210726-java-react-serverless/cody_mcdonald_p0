package com.revature.Project_0.documents;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCourses {

    private String id, username;
    private List<Course> courses = new ArrayList<>();

    public UserCourses(){super();}

    public UserCourses(String username){ this.username = username; };

    public UserCourses(String id, String username){
        this(username);
        this.id = id;
    }

    public UserCourses addCourses(Course... regCourses){
        courses.addAll(Arrays.asList(regCourses));
        return this;
    }

    // Setters and Getters

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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    //Overrides
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UserCourses that = (UserCourses) obj;
        return Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(courses, that.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, courses);
    }

    @Override
    public String toString() {
        return "UserFavorites{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", Courses=" + courses +
                '}';
    }


}
