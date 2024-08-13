package com.example.repositoryexercise.Controller;

import com.example.repositoryexercise.Model.User;
import com.example.repositoryexercise.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.updateUser(id, user);
        return ResponseEntity.status(200).body("User updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.status(200).body("User deleted");
    }

    @GetMapping("/search/{userName}/{password}")
    public ResponseEntity findByUserNameAndPassword(@PathVariable String userName, @PathVariable String password) {
        return ResponseEntity.ok(userService.findByUserNameAndPassword(userName, password));
    }

    @GetMapping("/searchEmail/{email}")
    public ResponseEntity findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @GetMapping("/searchRole/{role}")
    public ResponseEntity findByRole(@PathVariable String role) {
        List<User> users = userService.findByRole(role);
        if (users.isEmpty()) {
            return ResponseEntity.status(404).body("No users found");
        }
        return ResponseEntity.status(200).body("users found");
    }

    @GetMapping("/searchAge/{age}")
    public ResponseEntity findByAgeMoreThan(@PathVariable int age) {
        List<User> users = userService.findByAgeMoreThan(age);
        if (users.isEmpty()) {
            return ResponseEntity.status(404).body("No users found");
        }
        return ResponseEntity.status(200).body("users found");
    }
}
