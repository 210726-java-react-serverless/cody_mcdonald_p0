package com.revature.projectzero.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.revature.projectzero.documents.UserCourses;
import com.revature.projectzero.util.MongoClientFactory;
import com.revature.projectzero.util.exceptions.DataSourceException;

import org.bson.Document;

import java.util.List;

public class UserCoursesRepository implements CrudRepository<UserCourses> {

    //TODO finish these to prevent duplicates
    public UserCourses getUsersCourses(String username,String courseName) { return null;
    }

    public List<String> findRegisteredCoursesByUsername(String username){
        try {
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            MongoDatabase p0Db = mongoClient.getDatabase("p0");
            MongoCollection<Document> usersCollection = p0Db.getCollection("usercourses");
            Document queryDoc = new Document("username", username);
            Document userCourseDoc = usersCollection.find(queryDoc).first();
            if (userCourseDoc == null) return null;
            ObjectMapper mapper = new ObjectMapper();
            UserCourses userCourses = mapper.readValue(userCourseDoc.toJson(), UserCourses.class);
            userCourses.setId(userCourseDoc.get("_id").toString());

            return userCourses.getCourses();
        }
        catch (JsonMappingException jme) {
            jme.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An exception occurred while mapping the document.", jme);
        } catch (Exception e) {
            e.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An unexpected exception occurred.", e);
        }
    }

    public void joinCourse(String course,String username){
        try {
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            MongoDatabase p0Db = mongoClient.getDatabase("p0");
            MongoCollection<Document> userCoursesCollection = p0Db.getCollection("usercourses");
            Document updateDoc = new Document("courses", course);
            Document appendDoc = new Document("$push",updateDoc);
            Document searchDoc = new Document("username",username);
            userCoursesCollection.updateOne(searchDoc,appendDoc);

        }
        catch (Exception e) {
            e.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An unexpected exception occurred.", e);
        }
    }

    public void removeCourseFromUserList(String course, String username){
        try {
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            MongoDatabase p0Db = mongoClient.getDatabase("p0");
            MongoCollection<Document> userCoursesCollection = p0Db.getCollection("usercourses");
            Document removeDoc = new Document("courses", course);
            Document appendDoc = new Document("$pull",removeDoc);
            Document searchDoc = new Document("username",username);
            userCoursesCollection.updateOne(searchDoc,appendDoc);

        }
        catch (Exception e) {
            e.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An unexpected exception occurred.", e);
        }
    }

    public void updateCourseNameInAllUserLists(String originalName, String newName){
        try {
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            MongoDatabase p0Db = mongoClient.getDatabase("p0");
            MongoCollection<Document> userCoursesCollection = p0Db.getCollection("usercourses");

            //push the new name
            Document updateDoc = new Document("courses", newName);
            Document pushDoc = new Document("$push",updateDoc);
            Document searchDoc = new Document("courses", originalName);
            userCoursesCollection.updateMany(searchDoc, pushDoc);

            //pull the old name
            Document removalDoc = new Document("courses", originalName);
            Document pullDoc = new Document("$pull",removalDoc);
            userCoursesCollection.updateMany(searchDoc,pullDoc);


        }
        catch (Exception e) {
            e.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An unexpected exception occurred.", e);
        }
    }

    public void removeCourseFromAllUserLists(String course){

        try {
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            MongoDatabase p0Db = mongoClient.getDatabase("p0");
            MongoCollection<Document> userCoursesCollection = p0Db.getCollection("usercourses");

            Document updateDoc = new Document("courses", course);
            Document appendDoc = new Document("$pull",updateDoc);
            Document searchDoc = new Document("courses", course);
            userCoursesCollection.updateMany(searchDoc,appendDoc);

        }
        catch (Exception e) {
            e.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An unexpected exception occurred.", e);
        }

    }


    @Override
    public UserCourses findByID(int id) {
        return null;
    }

    //initialize the user's courseList
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
