package com.example.mySqlDatabase.service;

import com.example.mySqlDatabase.dto.UserDto;
import com.example.mySqlDatabase.model.User;
import com.example.mySqlDatabase.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;


@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public User addUser(@RequestBody UserDto userDto) {
        User user = new User(userDto);
        return userRepo.save(user);
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUser(int id) {
        return userRepo.findById(id);
    }

    public User update(int id, UserDto user) {
        Optional<User> opUser = userRepo.findById(id);
        if (opUser.isPresent()) {
            opUser.get().setFirstName(user.getFirstName());
            opUser.get().setLastName(user.getLastName());
            opUser.get().setGender(user.getGender());
            opUser.get().setSalary(user.getSalary());
            return userRepo.save(opUser.get());
        }
        return null;
    }

    public void delete(int id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            userRepo.deleteById(id);
        }
    }
}
