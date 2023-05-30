package com.example.mySqlDatabase.repository;

import com.example.mySqlDatabase.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
