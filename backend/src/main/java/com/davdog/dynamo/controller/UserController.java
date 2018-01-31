package com.davdog.dynamo.controller;

import com.davdog.dynamo.controller.json.UserRequest;
import com.davdog.dynamo.repositories.User;
import com.davdog.dynamo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin
@RestController
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/users")
  public Iterable<User> getUsers() {
    return userRepository.findAll();
  }

  @GetMapping("/users/{id}")
  public User getUser(@PathVariable String id) {
    Optional<User> user = userRepository.findById(id);
    return user.isPresent() ? user.get() : null;
  }

  @PostMapping("/users")
  public User createUser(@Valid @RequestBody UserRequest user) {
    return userRepository.save(new User(user.getFirstName(), user.getLastName()));
  }

  @PutMapping("/users/{id}")
  public User updateUser(@PathVariable String id, @Valid @RequestBody UserRequest user) {
    return userRepository.save(new User(id, user.getFirstName(), user.getLastName()));
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable String id) {
    userRepository.deleteById(id);
  }

}
