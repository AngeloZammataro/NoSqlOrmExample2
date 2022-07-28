package it2.develhope.NoSqlOrmExample.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collection;
import java.util.Collections;

//https://www.baeldung.com/spring-data-mongodb-tutorial
//noi siamo un client e ci colleghiamo al DB
@Configuration // annotiamo come configurazione
public class MongoDBConfig extends AbstractMongoClientConfiguration { //dobbiamo estendere AbstractMongoClientConfiguration...

    //...e importare il metodo getDatabaseName...
    @Override
    protected String getDatabaseName() {
        return "develhope";
    }

    //creiamo la connessione al mongoDB recuperiamo la stringa da mongodb
    //questo metodo possiamo recuperarlo da https://www.baeldung.com/spring-data-mongodb-tutorial

    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://develhope:develhope@cluster0.9kfkqck.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    //...e il metodo getMappingBasePackages
    @Override
    protected Collection<String> getMappingBasePackages() {
        //return super.getMappingBasePackages(); modifichiamo con:
        return Collections.singleton("co.develhope");
    }



    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}
