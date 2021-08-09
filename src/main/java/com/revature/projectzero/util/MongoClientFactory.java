package com.revature.projectzero.util;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import com.revature.projectzero.util.exceptions.DataSourceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class MongoClientFactory {

    private final MongoClient mongoClient;
    private static final MongoClientFactory mongoClientFactory = new MongoClientFactory();

    private final Logger logger = LogManager.getLogger(MongoClientFactory.class);

    private MongoClientFactory() {

        Properties appProperties = new Properties();

        try{
            appProperties.load(new FileReader("src/main/resources/application.properties"));

            String ipAddress = appProperties.getProperty("ipAddress");
            int port = Integer.parseInt(appProperties.getProperty("port"));
            String dbName = appProperties.getProperty("dbName");
            String username = appProperties.getProperty("username");
            char[] password = appProperties.getProperty("password").toCharArray();

            List<ServerAddress> hosts = Collections.singletonList(new ServerAddress(ipAddress, port));
            MongoCredential credentials = MongoCredential.createScramSha1Credential(username, dbName, password);
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyToClusterSettings(builder -> builder.hosts(hosts))
                    .credential(credentials)
                    .build();

            this.mongoClient = MongoClients.create(settings);




        }catch (FileNotFoundException fnfe) {
            logger.error("Unable to load database properties file.", fnfe);
            throw new DataSourceException("Unable to load database properties file.", fnfe);
        } catch(Exception e){
            logger.error("An unexpected exception occurred.", e);
            throw new DataSourceException("An unexpected exception occurred.", e);
        }

    }

    public void cleanUp(){
        mongoClient.close();
    }

    public static MongoClientFactory getInstance(){
        return mongoClientFactory;
    }

    public MongoClient getConnection(){
        return mongoClient;
    }
}
