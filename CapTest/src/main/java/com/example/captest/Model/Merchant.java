package com.example.captest.Model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Merchant {

    @NotNull(message = " (must not be id empty)")
    private String id;

    @NotNull(message = " (must not be name empty)")
    @Size(min = 3,message = " (have to be more name than 3 length long).")
    private String name;


}
