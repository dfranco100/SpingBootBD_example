package com.SpringBootDB_Assign.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.*;
import org.junit.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;



public class SpringBootDemoTests {

	@Autowired
    private UserRepository userRepository;
 
    @Test
    public void findAllUsers() {
        List<User> users = userRepository.findAll();
        assertNotNull(users);
        assertTrue(!users.isEmpty());
    }
 
    @Test
    public void findUserById() {
        User user = userRepository.findUserById(1);
        assertNotNull(user);
    }
 
    @Test
    public void createUser() {
        User user = new User(0, "John", "john@gmail.com");
        User savedUser = userRepository.create(user);
        User newUser = userRepository.findUserById(savedUser.getId());
        assertNotNull(newUser);
        assertEquals("John", newUser.getName());
        assertEquals("john@gmail.com", newUser.getEmail());
    }
}
