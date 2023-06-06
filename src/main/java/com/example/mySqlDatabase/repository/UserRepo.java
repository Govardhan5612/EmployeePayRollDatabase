package com.example.mySqlDatabase.repository;

import com.example.mySqlDatabase.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(value = "select * from employee_details,department where user_id=id and departments = :department",nativeQuery = true)
    List<User> searchByDepartment(String department);
}
