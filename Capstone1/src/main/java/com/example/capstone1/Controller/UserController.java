package com.example.capstone1.Controller;

import com.example.capstone1.Model.MerchantStock;
import com.example.capstone1.Model.Product;
import com.example.capstone1.Model.User;
import com.example.capstone1.Service.MerchantStockServ;
import com.example.capstone1.Service.ProductServ;
import com.example.capstone1.Service.UserServ;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cap/user")
@RequiredArgsConstructor
public class UserController {

    private  final UserServ userServ;
    private  final ProductServ productServ;



   //get
    @GetMapping("/get")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userServ.getUsers());
    }



    //add
@PostMapping("/add")
    public ResponseEntity addUsers(@Valid @RequestBody User user, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        userServ.addUsers(user);
    return ResponseEntity.status(HttpStatus.OK).body("Successfully");
    }



    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updUsers(@PathVariable String id,@Valid@RequestBody User user, Errors errors ){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isUpdate=userServ.updUsers(id,user);
                if(isUpdate)
                    return ResponseEntity.status(HttpStatus.OK).body("Successfully Update  :) \n");
                else
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry NOT_FOUND!!");
    }


    //Delete
  @DeleteMapping("/delete/{id}")
    public  ResponseEntity del(@PathVariable String id){
        boolean isDelete=userServ.delUsers(id);
        if (isDelete)
            return ResponseEntity.status(HttpStatus.OK).body("Successfully Delete  :) \n");
                else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry NOT_FOUND!!");




  }


private  final MerchantStockServ merchantStockServ;

    @PostMapping("/buyProduct")
    public ResponseEntity<String> buyProduct(
            @RequestParam String userId,
            @RequestParam String productId,
            @RequestParam String merchantId
    ) {
        if (!userServ.isValidUser(userId) || !merchantStockServ.isValidProductAndMerchant(productId, merchantId)) {
            return ResponseEntity.badRequest().body("Invalid user, product, or merchant ID");
        }

        Optional<MerchantStock> optionalMerchantStock = null;
        MerchantStock merchantStock = optionalMerchantStock.orElse(null);
        if (merchantStock == null) {
            throw new RuntimeException("MerchantStock not found for Product ID: " + productId + " and Merchant ID: " + merchantId);
        }

        Optional<User> optionalUser = userServ.getUserById(userId);
        optionalMerchantStock = merchantStockServ.getMerchantStocks(productId, merchantId);

        User user = optionalUser.orElse(null);
        if (user == null) {
            throw new RuntimeException("User not found for ID: " + userId);
        }


        if (merchantStock.getStock() <= 0) {
            return ResponseEntity.badRequest().body("Product is out of stock");
        }

        Optional<Product> optionalProduct = productServ.getProductById(productId);

        double productPrice = optionalProduct.map(Product::getPrice)
                .orElseThrow(() -> new RuntimeException("Product not found for ID: " + productId));

        if (user.getBalance() < productPrice) {
            return ResponseEntity.badRequest().body("Insufficient balance to buy the product");
        }

        merchantStock.setStock(merchantStock.getStock() - 1);
        user.setBalance(user.getBalance() - productPrice);

        Optional<MerchantStock> savedMerchantStock = merchantStockServ.saveMerchantStock(merchantStock);
        Optional<User> savedUser = userServ.saveUser(user);

        if (savedMerchantStock.isEmpty() || savedUser.isEmpty()) {
            throw new RuntimeException("Failed to save MerchantStock or User");
        }

//        Optional<MerchantStock> savedMerchantStock = merchantStockServ.saveMerchantStock(merchantStock);
//
//        if (savedMerchantStock.isPresent()) {
//            MerchantStock savedStock = savedMerchantStock.get();
//        } else {
//            System.out.println("Failed to save MerchantStock");
//        }


        return ResponseEntity.ok("Product bought successfully");
    }



}
