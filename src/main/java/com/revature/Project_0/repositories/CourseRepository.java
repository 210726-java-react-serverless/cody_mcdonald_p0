package com.revature.Project_0.repositories;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.revature.Project_0.documents.AppUser;
import com.revature.Project_0.documents.Course;
import com.revature.Project_0.util.MongoClientFactory;
import com.revature.Project_0.util.exceptions.DataSourceException;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository implements CrudRepository<Course> {

    //TODO finish these to prevent duplicate courses
    public Course findCourseByName(String courseName) {
        try {
            // Get connection
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            // Access database
            MongoDatabase p0Db = mongoClient.getDatabase("p0");
            // Access collection
            MongoCollection<Document> usersCollection = p0Db.getCollection("courses");
            // Create new document with provided values to query database
            Document queryDoc = new Document("courseName", courseName);
            // Search the database for an instance of a collection with the matching values
            Document courseDoc = usersCollection.find(queryDoc).first();
            // Return null if the values were not propagated and therefore not found
            if (courseDoc == null) return null;
            // Create jackson object mapper
            ObjectMapper mapper = new ObjectMapper();
            // Converting the collection into a Json document and providing Jackson with the class
            // Allows Jackson to read the values and map them to the corresponding object.
            Course c = mapper.readValue(courseDoc.toJson(), Course.class);
            // Handling the ID set by mongodb
            c.setId(courseDoc.get("_id").toString());
            c.setOpen((boolean)courseDoc.get("isOpen"));
            return c;

        } catch (JsonMappingException jme) {
            jme.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An exception occurred while mapping the document.", jme);
        } catch (Exception e) {
            e.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An unexpected exception occurred.", e);
        }
    }

    public Course findCourseByAbbreviation(String courseAbv) {
        try {
            // Get connection
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            // Access database
            MongoDatabase p0Db = mongoClient.getDatabase("p0");
            // Access collection
            MongoCollection<Document> usersCollection = p0Db.getCollection("courses");
            // Create new document with provided values to query database
            Document queryDoc = new Document("courseAbbreviation", courseAbv);
            // Search the database for an instance of a collection with the matching values
            Document courseDoc = usersCollection.find(queryDoc).first();
            // Return null if the values were not propagated and therefore not found
            if (courseDoc == null) return null;
            // Create jackson object mapper
            ObjectMapper mapper = new ObjectMapper();
            // Converting the collection into a Json document and providing Jackson with the class
            // Allows Jackson to read the values and map them to the corresponding object.
            Course c = mapper.readValue(courseDoc.toJson(), Course.class);
            // Handling the ID set by mongodb
            c.setId(courseDoc.get("_id").toString());
            c.setOpen((boolean)courseDoc.get("isOpen"));
            return c;

        } catch (JsonMappingException jme) {
            jme.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An exception occurred while mapping the document.", jme);
        } catch (Exception e) {
            e.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An unexpected exception occurred.", e);
        }
    }


    public List<Course> retrieveCourses() {
        try {
            List<Course> courses = new ArrayList<>();
            // Get connection
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            // Access database
            MongoDatabase p0Db = mongoClient.getDatabase("p0");
            // Access collection
            MongoCollection<Document> usersCollection = p0Db.getCollection("courses");
            // Create new document with provided values to query database
            Document queryDoc = new Document("isOpen", true);
            // Retrieve an iterable document of all collections
            FindIterable<Document> openCoursesDoc = usersCollection.find(queryDoc);
            // Return null if the values were not propagated and therefore not found
            if (openCoursesDoc == null) return null;
            // Create jackson object mapper
            ObjectMapper mapper = new ObjectMapper();
            Course openCourse = new Course();

            for(Document a: openCoursesDoc){
                openCourse = mapper.readValue(a.toJson(), Course.class);
                openCourse.setId(a.get("_id").toString());
                openCourse.setOpen((boolean)a.get("isOpen"));
                courses.add(openCourse);
            }
            return courses;

        } catch (JsonMappingException jme) {
            jme.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An exception occurred while mapping the document.", jme);
        } catch (Exception e) {
            e.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An unexpected exception occurred.", e);
        }
    }

    public void updatingCourseName(Course original,String newName){
        try {
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            MongoDatabase p0Db = mongoClient.getDatabase("p0");
            MongoCollection<Document> coursesCollection = p0Db.getCollection("courses");
            Document updateDoc = new Document("courseName", newName);
            Document appendDoc = new Document("$set",updateDoc);
            Document searchDoc = new Document("courseName",original.getCourseName());
            coursesCollection.updateOne(searchDoc,appendDoc);
        } catch (Exception e) {
            e.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An unexpected exception occurred.", e);
        }

    }

    public void updatingCourseAbv(Course original, String newAbv){
        try {
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            MongoDatabase p0Db = mongoClient.getDatabase("p0");
            MongoCollection<Document> coursesCollection = p0Db.getCollection("courses");
            Document updateDoc = new Document("courseAbbreviation", newAbv);
            Document appendDoc = new Document("$set",updateDoc);
            Document searchDoc = new Document("courseAbbreviation", original.getCourseAbbreviation());
            coursesCollection.updateOne(searchDoc,appendDoc);

        } catch (Exception e) {
            e.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An unexpected exception occurred.", e);
        }

    }

    public void updatingCourseDesc(Course original, String newDesc){
        try {
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            MongoDatabase p0Db = mongoClient.getDatabase("p0");
            MongoCollection<Document> coursesCollection = p0Db.getCollection("courses");
            Document updateDoc = new Document("courseDetail", newDesc);
            Document appendDoc = new Document("$set",updateDoc);
            Document searchDoc = new Document("courseAbbreviation",original.getCourseAbbreviation());
            coursesCollection.updateOne(searchDoc,appendDoc);


        } catch (Exception e) {
            e.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An unexpected exception occurred.", e);
        }

    }

    public void openClose(Course course){
        try {
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            MongoDatabase p0Db = mongoClient.getDatabase("p0");
            MongoCollection<Document> coursesCollection = p0Db.getCollection("courses");
            if(course.isOpen()) {
                Document updateDoc = new Document("isOpen", false);
                Document appendDoc = new Document("$set", updateDoc);
                Document searchDoc = new Document("courseAbbreviation", course.getCourseAbbreviation());
                coursesCollection.updateOne(searchDoc, appendDoc);
            }else
            {
                Document updateDoc = new Document("isOpen", true);
                Document appendDoc = new Document("$set", updateDoc);
                Document searchDoc = new Document("courseAbbreviation", course.getCourseAbbreviation());
                coursesCollection.updateOne(searchDoc, appendDoc);
            }


        } catch (Exception e) {
            e.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An unexpected exception occurred.", e);
        }
    }



    @Override
    public Course findByID(int id) {
        return null;
    }

    //Save the course to the database
    @Override
    public Course save(Course newCourse) {
        try {
            // Get connection
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            // Access database
            MongoDatabase p0Db = mongoClient.getDatabase("p0");
            // Access collection
            MongoCollection<Document> courseCollection = p0Db.getCollection("courses");
            // Create new user document with provided values
            Document newCourserDoc = new Document("courseName", newCourse.getCourseName())
                    .append("courseAbbreviation", newCourse.getCourseAbbreviation())
                    .append("courseDetail", newCourse.getCourseDetail())
                    .append("isOpen", newCourse.isOpen());
            //Insert the new user document into the database
            courseCollection.insertOne(newCourserDoc);
            //Set the user's ID to the ID generated by the database.
            newCourse.setId(newCourserDoc.get("_id").toString());

            return newCourse;

        } catch (Exception e) {
            e.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An unexpected exception occurred.", e);
        }
    }

    @Override
    public boolean update(Course updatedResource) {
        return false;
    }

    @Override
    public boolean deleteByID(int id) {
        return false;
    }


}
