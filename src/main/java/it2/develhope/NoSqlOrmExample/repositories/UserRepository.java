package it2.develhope.NoSqlOrmExample.repositories;

import it2.develhope.NoSqlOrmExample.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

//è sempre un'interfaccia e si occupa del collegamento al MongoDB
//questo servizio si occupa della gestione della classe User
public interface UserRepository extends MongoRepository<User, String> {
}
