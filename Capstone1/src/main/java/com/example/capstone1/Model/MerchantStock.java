package com.example.capstone1.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class MerchantStock {



    @NotNull(message = "must not be empty 'id' ")
    @Size(min = 2)
    private String id;


    @NotNull(message = "must not be empty 'productid' ")
    @Size(min = 2)
    private String productid;



    @NotNull(message = "must not be empty 'merchantid' ")
    @Size(min = 2)
    private String merchantid;


    @NotNull(message = "Must be not empty")
    @Min(value = 10,message = "must be stock greater than or equal to 10")
    private int stock;



}
