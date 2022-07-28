package it2.develhope.NoSqlOrmExample.controllers;

import it2.develhope.NoSqlOrmExample.entities.User;
import it2.develhope.NoSqlOrmExample.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // è un controller REST
@RequestMapping("/user") // mappiamo user
public class UserController {

    //dobbiamo richiamare l'interfaccia UserRepository
    @Autowired
    UserRepository userRepository;

    // facciamo un PostMapping per creare un User
    @PostMapping("")
    public User createUser(@RequestBody User user){
        user.setId(null);
        return userRepository.save(user);
    }
    // facciamo un GetMapping per ottenere una lista di tutti gli User
    @GetMapping
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    //facciamo un GetMapping per ottenere un User tramite id
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable String id){
        return userRepository.findById(id);
    }
}
