package com.brodep.simpleCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    public Controller(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    UserRepo userRepo;
    @GetMapping()
    Iterable<User> getAll(){
        return userRepo.findAll();
    }
    @PostMapping()
    void add(@RequestBody User user){
        userRepo.save(user);
    }

    /*
    @GetMapping("/{id}")
    User getById(PathVariable)

     */
}
