package com.vastika.training.capstone.suchanaapi.controller;

import com.vastika.training.capstone.suchanaapi.exceptions.SuchanaDataException;
import com.vastika.training.capstone.suchanaapi.models.User;
import com.vastika.training.capstone.suchanaapi.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/authors")
    public ResponseEntity<List<User>> findAll(){
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    }

    @RequestMapping("/authors/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") int id){
        return new ResponseEntity<>(this.userService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/authors/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateAuthor(@RequestBody User user, @PathVariable("id") int id){
        log.info("updateAuthor() -> {}", id);
        user.setId(id);
        return new ResponseEntity<>(this.userService.update(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/authors", method = RequestMethod.POST)
    public ResponseEntity<User> createAuthor(@Valid @RequestBody User user, BindingResult result){
        log.info("createAuthor() -> {}", user);
        if(result.hasErrors()){
            throw new SuchanaDataException("Invalid Payload", result.getFieldErrors());
        }
        user.setDateCreated(LocalDateTime.now());
        return new ResponseEntity<>(this.userService.createAuthor(user), HttpStatus.CREATED);
    }

}
