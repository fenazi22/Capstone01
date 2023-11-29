package com.example.capstone1.Model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {


    @NotNull(message = "must not be empty id")
    @Size(min = 2, message = "Must be input id:")
    private String id;


    @NotNull(message = "Please input Name")
    @Size(min = 3,message = "have to be more than 3 length long")
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String name;


    @NotNull(message = "must not be empty price: ")
    @Positive
    private double price;


    @NotNull(message = "should be input 'categoryID' ")
    @Size(min = 2, message = "input 'categoryID' more then 2 ")
    private String categoryID;


}
