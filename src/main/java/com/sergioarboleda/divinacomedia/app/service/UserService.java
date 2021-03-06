package com.sergioarboleda.divinacomedia.app.service;


import com.sergioarboleda.divinacomedia.app.model.User;
import com.sergioarboleda.divinacomedia.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @utor Angel Calderon
 */

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAll() {
        return repository.getAll();

    }

    public User save(User user) {
        if (user.getId() == null) {
            Optional<User> existUsers = repository.getUserByNameOrEmail(user.getName(), user.getEmail());
            if (existUsers.isEmpty()) {
                return repository.save(user);
            } else {
                return user;
            }
        } else {
            Optional<User> existUser = repository.getUserById(user.getId());
            if (existUser.isEmpty()) {
                return repository.save(user);
            } else {
                return user;
            }
        }
    }
    public boolean getUserByEmail(String email){
        return repository.getUserByEmail(email).isPresent();
    }
    public User getUserByEmailAndPassword(String email, String password){
    Optional<User> user = repository.getUserByEmailAndPassword(email,password);
    if (user.isPresent()){
        return  user.get();
    }else{
        return new User(null,email,password,"NO DEFINIDO");
    }

    }
}
