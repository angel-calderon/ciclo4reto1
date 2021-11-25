package com.sergioarboleda.divinacomedia.app.repositories.crud;
/**
 * @uthor Angel Calderon
 */

import com.sergioarboleda.divinacomedia.app.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserCrudRepository extends CrudRepository<User, Integer> {

    public Optional<User> findByName(String name);

    public Optional<User> findByEmail(String email);

    public Optional<User> findByNameOrEmail(String name, String email);

    public Optional<User> findByEmailAndPassword(String email, String password);


}
