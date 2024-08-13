package com.example.repositoryexercise.Repository;

import com.example.repositoryexercise.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserNameAndPassword(String userName, String password);

    User findByEmail(String email);

    List<User> findByRole(String role);

    @Query("select u from User u where u.age > ?1")
    List<User> findUsersByAgeMoreThan(int age);
}
