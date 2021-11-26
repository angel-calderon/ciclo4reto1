package com.sergioarboleda.divinacomedia.app.controller;


import com.sergioarboleda.divinacomedia.app.model.User;
import com.sergioarboleda.divinacomedia.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @uthor Angel Calderón
 */


@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")  // habilita el acceso desde cualquier origen
public class UserController {
@Autowired
private UserService service;


@GetMapping("/all")
public List<User> getUsers() {
        return service.getAll();
        }

@PostMapping("/new")
@ResponseStatus(HttpStatus.CREATED)
public User save(@RequestBody User user) {
        return service.save(user);
        }

@GetMapping("/{email}")
public boolean exixtEmail(@PathVariable("email") String email){
        return service.getUserByEmail(email);
        }
@GetMapping("/{email}/{password}")
public User authUser(@PathVariable("email")String email,@PathVariable("password") String password){
    return service.getUserByEmailAndPassword(email, password);
}

}
