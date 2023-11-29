package com.example.capstone1.Controller;

import com.example.capstone1.Model.Merchant;
import com.example.capstone1.Service.MerchantServ;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cap/mer")
@RequiredArgsConstructor
public class MerchantController {

    private  final MerchantServ merchantServ;



    //get
    @GetMapping("/get")
    public ResponseEntity getMerchants(){
        return ResponseEntity.status(HttpStatus.OK).body(merchantServ.getMerchants());
    }




    //add
    @PostMapping("/add")
    public ResponseEntity addMerchants(@Valid@RequestBody Merchant merchant, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }

        merchantServ.addMerchants(merchant);
        return  ResponseEntity.status(HttpStatus.OK).body("Successfully added  ^_^ ");
    }




    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updMerchants(@PathVariable String id,@Valid@RequestBody Merchant merchant,Errors errors){
        if (errors.hasErrors()){
           boolean message=merchantServ.updMerchants(id,merchant);
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isUpdate=merchantServ.updMerchants(id,merchant);
        if (isUpdate){
            return ResponseEntity.status(HttpStatus.OK).body("Successfully Update ^_^ ");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry NOT_FOUND!! !_!");
        }

    }



    //Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delMerchants(@PathVariable String id){

        boolean isDelete=merchantServ.delMerchants(id);
        if (isDelete)
                return ResponseEntity.status(HttpStatus.OK).body("Successfully Deleted ^_^ ");
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry NOT_FOUND!! !_!");

    }





}
