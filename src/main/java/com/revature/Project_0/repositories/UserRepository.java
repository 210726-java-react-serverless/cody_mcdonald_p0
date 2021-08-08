package com.revature.Project_0.repositories;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.revature.Project_0.util.exceptions.DataSourceException;
import com.revature.Project_0.documents.AppUser;
import com.revature.Project_0.util.MongoClientFactory;
import org.bson.Document;

public class UserRepository implements CrudRepository<AppUser>{


    public AppUser findUserByCredentials(String username, String password) {

        try {
            // Get connection
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            // Access database
            MongoDatabase p0Db = mongoClient.getDatabase("p0");
            // Access collection
            MongoCollection<Document> usersCollection = p0Db.getCollection("users");
            // Create new document with provided values to query database
            Document queryDoc = new Document("username", username).append("password", password);
            // Search the database for an instance of a collection with the matching values
            Document authUserDoc = usersCollection.find(queryDoc).first();
            // Return null if the values were not propagated and therefore not found
            if (authUserDoc == null) return null;
            // Create jackson object mapper
            ObjectMapper mapper = new ObjectMapper();
            // Converting the collection into a Json document and providing Jackson with the class
            // Allows Jackson to read the values and map them to the corresponding object.
            AppUser authUser = mapper.readValue(authUserDoc.toJson(), AppUser.class);
            // Handling the ID set by mongodb
            authUser.setId(authUserDoc.get("_id").toString());
            // Have to manually pull this since booleans are being cast to an object that isn't a Boolean
            authUser.setFaculty((boolean)authUserDoc.get("isFaculty"));
            return authUser;

        } catch (JsonMappingException jme) {
            jme.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An exception occurred while mapping the document.", jme);
        } catch (Exception e) {
            e.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An unexpected exception occurred.", e);
        }

    }

    public AppUser findUserByUsername(String username) {
        try {
            // Get connection
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            // Access database
            MongoDatabase p0Db = mongoClient.getDatabase("p0");
            // Access collection
            MongoCollection<Document> usersCollection = p0Db.getCollection("users");
            // Create new document with provided values to query database
            Document queryDoc = new Document("username", username);
            // Search the database for an instance of a collection with the matching values
            Document authUserDoc = usersCollection.find(queryDoc).first();
            // Return null if the values were not propagated and therefore not found
            if (authUserDoc == null) return null;
            // Create jackson object mapper
            ObjectMapper mapper = new ObjectMapper();
            // Converting the collection into a Json document and providing Jackson with the class
            // Allows Jackson to read the values and map them to the corresponding object.
            AppUser authUser = mapper.readValue(authUserDoc.toJson(), AppUser.class);
            // Handling the ID set by mongodb
            authUser.setId(authUserDoc.get("_id").toString());
            return authUser;

        }catch (JsonMappingException jme) {
            jme.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An exception occurred while mapping the document.", jme);
        } catch (Exception e) {
            e.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An unexpected exception occurred.", e);
        }

    }


    public AppUser findUserByEmail(String email) {
        try {
            // Get connection
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            // Access database
            MongoDatabase p0Db = mongoClient.getDatabase("p0");
            // Access collection
            MongoCollection<Document> usersCollection = p0Db.getCollection("users");
            // Create new document with provided values to query database
            Document queryDoc = new Document("email", email);
            // Search the database for an instance of a collection with the matching values
            Document authUserDoc = usersCollection.find(queryDoc).first();
            // Return null if the values were not propagated and therefore not found
            if (authUserDoc == null)
                return null;
            // Create jackson object mapper
            ObjectMapper mapper = new ObjectMapper();
            // Converting the collection into a Json document and providing Jackson with the class
            // Allows Jackson to read the values and map them to the corresponding object.
            AppUser authUser = mapper.readValue(authUserDoc.toJson(), AppUser.class);
            // Handling the ID set by mongodb
            authUser.setId(authUserDoc.get("_id").toString());
            return authUser;

        }catch (JsonMappingException jme) {
            jme.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An exception occurred while mapping the document.", jme);
        } catch (Exception e) {
            e.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An unexpected exception occurred.", e);
        }
    }


    @Override
    public AppUser findByID(int id) {
        return null;
    }

    @Override
    public AppUser save(AppUser newUser) {


        try {
            // Get connection
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            // Access database
            MongoDatabase p0Db = mongoClient.getDatabase("p0");
            // Access collection
            MongoCollection<Document> usersCollection = p0Db.getCollection("users");
            // Create new user document with provided values
            Document newUserDoc = new Document("firstName", newUser.getFirstName())
                    .append("lastName", newUser.getLastName())
                    .append("email", newUser.getEmail())
                    .append("username", newUser.getUsername())
                    .append("password", newUser.getPassword())
                    .append("isFaculty", newUser.isFaculty());
            //Insert the new user document into the database
            usersCollection.insertOne(newUserDoc);
            //Set the user's ID to the ID generated by the database.
            newUser.setId(newUserDoc.get("_id").toString());

            return newUser;

        } catch (Exception e) {
            e.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An unexpected exception occurred.", e);
        }

    }

    @Override
    public boolean update(AppUser updatedResource) {
        return false;
    }

    @Override
    public boolean deleteByID(int id) {
        return false;
    }
}
