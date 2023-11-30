package com.example.captest.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {

    @NotNull(message = "(must not be id empty)")
    private  String id;

    @NotNull(message = "(must not be productID empty)")
    private String productid;

    @NotNull(message = "(must not be merchantID empty)")
    private String merchantid;

    @NotNull(message = "(must not be productID empty)")
    @Min(value = 10,message = "(have to be stock more than 10 at start)")
    private int  stock;





}
