package com.brodep.simpleCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class Controller {
    UserRepo userRepo;
    @Autowired
    public Controller(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping()
    Iterable<User> getAll(){
        return userRepo.findAll();
    }

    @PostMapping()
    void add(@RequestBody User user){
        userRepo.save(user);
    }

    @GetMapping("/{id}")
    User getById(@PathVariable Long id){
        return userRepo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    void edit(@PathVariable Long id, @RequestBody User user) throws NullPointerException{
        if (userRepo.findById(id).isEmpty())
            return;
        user.setId(id);
        userRepo.save(user);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id){
        userRepo.deleteById(id);
    }

    @DeleteMapping()
    void deleteAll(){
        userRepo.deleteAll();
    }
}
