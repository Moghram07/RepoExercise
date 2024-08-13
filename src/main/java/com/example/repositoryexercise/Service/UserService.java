package com.example.repositoryexercise.Service;


import com.example.repositoryexercise.ApiException.ApiException;
import com.example.repositoryexercise.Model.User;
import com.example.repositoryexercise.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(Integer id){
        User u = userRepository.getById(id);
        if(u == null){
            throw new ApiException("User not found");
        }
        userRepository.delete(u);
    }

    public void updateUser(Integer id, User user){
        User u = userRepository.getById(id);
        if(u == null){
            throw new ApiException("User not found");
        }
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setAge(user.getAge());
        u.setRole(user.getRole());

        userRepository.save(u);
    }

    public User findByUserNameAndPassword(String userName, String password){
        User u = userRepository.findByUserNameAndPassword(userName, password);
        if(u == null){
            throw new ApiException("User not found");
        }
        return u;
    }

    public User findByEmail(String email){
        User u = userRepository.findByEmail(email);
        if(u == null){
            throw new ApiException("Email not found");
        }
        return u;
    }

    public List<User> findByRole(String role){
        List<User> users = userRepository.findByRole(role);
        if(users == null){
            throw new ApiException("Users with role" + role + " not found");
        }
        return users;
    }

    public List<User> findByAgeMoreThan(Integer age){
        List<User> users = userRepository.findUsersByAgeMoreThan(age);
        if(users == null){
            throw new ApiException("Users above " + age + " not found");
        }
        return users;
    }

}
