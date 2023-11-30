package com.example.captest.Model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {


    @NotNull(message = "must not be id empty")
    private String id;

    @NotNull(message = "must not be id empty")
    @Size(min = 4,message = "must be name more than 3 length long")
    private  String name;

}
