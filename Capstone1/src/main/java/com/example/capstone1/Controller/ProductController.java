package com.example.capstone1.Controller;

import com.example.capstone1.Model.Product;
import com.example.capstone1.Service.ProductServ;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cap/prod")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServ productServ;



    //Get
     @GetMapping("/get")
    public ResponseEntity getProduct(){
    return ResponseEntity.status(HttpStatus.OK).body(productServ.getProduct());
    }




    //add
    @PostMapping("/add")
    public ResponseEntity addProduct(@Valid @RequestBody Product product, Errors errors ){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
         productServ.addProduct(product);
         return ResponseEntity.status(HttpStatus.OK).body("Added Successfully :) ");

     }





    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updProduct(@PathVariable String id, @Valid@RequestBody Product product, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isUpdate=productServ.updProduct(id,product);
        if (isUpdate)
            return ResponseEntity.status(HttpStatus.OK).body("Update Successfully :) ");
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry NOT_FOUND!! :( ");

    }






    //Delete
    @DeleteMapping("/delete/{id}")
public  ResponseEntity delProduct(@PathVariable String id){

         boolean isDelete=productServ.delProduct(id);
         if (isDelete)
             return ResponseEntity.status(HttpStatus.OK).body("Successfully Deleted :) ");
         else
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry NOT_FOUND!! :( ");

    }





}
