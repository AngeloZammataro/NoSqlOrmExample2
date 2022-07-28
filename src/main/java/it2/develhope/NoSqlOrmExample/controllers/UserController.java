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
    private UserRepository userRepository;

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

    @GetMapping("/count")
    public long count(){
        return userRepository.count();
    }

    //facciamo un GetMapping per ottenere un User tramite id
    @GetMapping("/{id}")
    public User getUsers(@PathVariable String id) throws Exception{
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new Exception("User is not found");
        }
    }

    @PutMapping("/{id}")
    public User editUser(@PathVariable String id, @RequestBody  User user) throws Exception{
        if(!userRepository.existsById(id)) throw new Exception("User is not found");
        user.setId(id);
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        userRepository.deleteById(id);
    }
}
