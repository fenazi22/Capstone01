package com.example.capstone1.Model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Merchant {


    @NotNull(message = "must not be empty id")
    @Size(min = 2, message = "Must be input id:")
    private String id;


    @NotNull(message = "Please input Name")
    @Size(min = 3,message = "have to be more than 3 length long")
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String name;


}
