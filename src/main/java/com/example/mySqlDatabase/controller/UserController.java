package com.example.mySqlDatabase.controller;

import com.example.mySqlDatabase.dto.ResponseDto;
import com.example.mySqlDatabase.dto.UserDto;
import com.example.mySqlDatabase.model.User;
import com.example.mySqlDatabase.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addUser(@Valid @RequestBody UserDto userDto) {

        userService.addUser(userDto);
        ResponseDto dto = new ResponseDto("The data added", userDto);
        return new ResponseEntity<ResponseDto>(dto, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseDto> getUsers() {
        List<User> user = userService.getUsers();
        ResponseDto dto = new ResponseDto("All Users Data", user);
        return new ResponseEntity<ResponseDto>(dto, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDto> getUser(@PathVariable int id) {
        User user = userService.getUser(id);
        ResponseDto dto = new ResponseDto("Users Data", user);
        return new ResponseEntity<ResponseDto>(dto, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> update(@PathVariable int id, @Valid @RequestBody UserDto user) {
        userService.update(id, user);
        ResponseDto dto = new ResponseDto("Updated user data", user);
        return new ResponseEntity<ResponseDto>(dto, HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable int id) {
        userService.delete(id);
        ResponseDto dto = new ResponseDto("Delete", id + (" Deleted "));
        return new ResponseEntity<ResponseDto>(dto, HttpStatus.ACCEPTED);
    }
    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDto> findByDepartment(@PathVariable String department) {
        List<User> user = userService.department(department);
        if (user.isEmpty()){
            ResponseDto dto = new ResponseDto("User data "+department, department+" department is not present in the database");
            return new ResponseEntity<ResponseDto>(dto, HttpStatus.BAD_REQUEST);
        }
        ResponseDto dto = new ResponseDto("Users Data", user);
        return new ResponseEntity<ResponseDto>(dto, HttpStatus.OK);
    }
}
