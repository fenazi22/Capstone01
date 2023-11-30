package com.example.captest.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {


    @NotNull(message = "must not be id empty")
    private  String id;


    @NotNull(message = "(must not be username empty)")
    @Size(min = 5,message = "(have to be more than 5 length long)")
    private  String username;


    @NotNull(message = "(must not be password empty)")
    @Size(min = 6,message = "(have to be more than 5 length long)")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d).+$",message = "have to be more than 6 length long, must have \n" +
            "characters and digits")
    private  String password;


    @NotNull(message = "(must not be empty, )")
    @Email(message = "(must be valid email)")
    private  String email;


    @NotNull(message = "(must not be role empty)")
    @Pattern(regexp = "(Admin|admin|Customer|customer)",message = "have to be in ( “Admin”,”Customer”)")
    private  String role;


    @NotNull(message = "(must not be empty)")
    @PositiveOrZero(message = "have to be positive")
    private double balance;




}
