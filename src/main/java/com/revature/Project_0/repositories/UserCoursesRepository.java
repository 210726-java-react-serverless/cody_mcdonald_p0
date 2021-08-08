package com.revature.Project_0.repositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.revature.Project_0.documents.UserCourses;
import com.revature.Project_0.util.MongoClientFactory;
import com.revature.Project_0.util.exceptions.DataSourceException;

import org.bson.Document;

public class UserCoursesRepository implements CrudRepository<UserCourses> {

    //TODO finish these to prevent duplicates
    public UserCourses findUserCoursesByName(String courseName) {
        return null;
    }

    public UserCourses findUserCoursesByAbbreviation(String courseAbv) {
        return null;
    }


    @Override
    public UserCourses findByID(int id) {
        return null;
    }

    //Save the course to the database
    @Override
    public UserCourses save(UserCourses newCourseList) {
        try {
            // Get connection
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            // Access database
            MongoDatabase p0Db = mongoClient.getDatabase("p0");
            // Access collection
            MongoCollection<Document> usersCollection = p0Db.getCollection("usercourses");
            // Create new document with provided values
            Document newListDoc = new Document("username", newCourseList.getUsername())
                    .append("courses", newCourseList.getCourses());
            //Insert the new user document into the database
            usersCollection.insertOne(newListDoc);
            //Set the ID to the ID generated by the database.
            newCourseList.setId(newListDoc.get("_id").toString());

            return newCourseList;

        } catch (Exception e) {
            e.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An unexpected exception occurred.", e);
        }
    }

    @Override
    public boolean update(UserCourses updatedResource) {
        return false;
    }

    @Override
    public boolean deleteByID(int id) {
        return false;
    }


}