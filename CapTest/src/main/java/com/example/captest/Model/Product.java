package com.example.captest.Model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {


    @NotNull(message = "must not be empty")
    private  String id;

    @NotNull(message = "must not be name empty")
   @Size(min = 3,message = "must  to be name more than 3 length long")
    private  String name;

    @NotNull(message = "must not be  price empty")
    @PositiveOrZero(message = "must not be empty, must be positive number")
    private double price;

    @NotNull(message = "must not be categoryID empty")
    private  String categoryID;


}
