package com.example.capstone1.Model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {


    @NotNull(message = "must not be empty 'id'\n")
    @Size(min = 3, message = "Should be id more the 3")
    private String id;


    @NotNull(message = "must not be empty 'userName'\n")
    @Size(min = 5,message = "have to be more than 5 length long")
    private String userName;


    @NotNull(message = "must not be empty 'password'\n")
    @Size(min = 6,message = "have to be more than 6 length long")
    private String password;




    @Email
    @NotNull(message = "must not be empty 'email'\n")

    private String email;


    @NotNull(message = "must not be empty 'role'\n")
    @Pattern(regexp = "(Admin|Customer)")
    private String role;


    @NotNull(message = "must not be empty 'balance'\n")
    @Positive(message = "have to be positive")
    private double balance;




}
