package com.meditrack.controller;

import com.meditrack.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final List<User> users = new ArrayList<>();

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        Optional<User> existing = users.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(user.getEmail()))
                .findFirst();
        if (existing.isPresent()) {
            return ResponseEntity.status(409).build();
        }
        users.add(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User login) {
        boolean ok = users.stream().anyMatch(u ->
                u.getEmail().equalsIgnoreCase(login.getEmail()) &&
                        u.getPassword().equals(login.getPassword())
        );
        if (ok) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
