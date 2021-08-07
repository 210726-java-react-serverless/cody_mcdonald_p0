package com.revature.Project_0.repositories;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.revature.Project_0.exceptions.DataSourceException;
import com.revature.Project_0.documents.AppUser;
import com.revature.Project_0.util.MongoClientFactory;
import org.bson.Document;

public class UserRepository implements CrudRepository<AppUser>{


    public AppUser findUserByCredentials(String username, String password) {

        try {
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            MongoDatabase p0Database = mongoClient.getDatabase("p0");
            MongoCollection<Document> usersCollection = p0Database.getCollection("users");
            Document queryDoc = new Document("username", username).append("password", password);
            Document authUserDoc = usersCollection.find(queryDoc).first();

            if (authUserDoc == null) {
                return null;
            }

            ObjectMapper mapper = new ObjectMapper();
            AppUser authUser = mapper.readValue(authUserDoc.toJson(), AppUser.class);
            authUser.setId(authUserDoc.get("_id").toString());
            return authUser;

        } catch (JsonMappingException jme) {
            jme.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An exception occurred while mapping the document.", jme);
        } catch (Exception e) {
            e.printStackTrace(); // TODO log this to a file
            throw new DataSourceException("An unexpected exception occurred.", e);
        }

    }

    //TODO push user info to repository

    @Override
    public AppUser findByID(int id) {
        return null;
    }

    @Override
    public AppUser save(AppUser newResource) {
        return null;
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
