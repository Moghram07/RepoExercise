package com.example.repositoryexercise.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "varchar(15) not null")
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 4, message = "name should be 4 or more characters")
    private String name;

    @Column(columnDefinition = "varchar(15) unique not null")
    @NotEmpty(message = "userName should not be empty")
    @Size(min = 4, message = "user name should be 4 or more characters")
    private String userName;

    @Column(columnDefinition = "varchar(20) not null")
    @NotNull(message = "Password cannot be null")
    private String password;

    @Column(columnDefinition = "varchar(25) unique not null")
    @NotNull(message = "Email cannot be null")
    @Email(message = "Must be a valid email format")
    private String email;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "Age cannot be null")
    private Integer age;

    @Column(columnDefinition = "varchar (5) not null")
    @NotNull(message = "Role cannot be null")
    @Pattern(regexp = "user|admin", message = "Role must be either 'JOB_SEEKER' or 'EMPLOYER' only")
    private String role;
}
