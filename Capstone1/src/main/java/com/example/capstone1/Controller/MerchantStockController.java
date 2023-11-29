package com.example.capstone1.Controller;

import com.example.capstone1.Model.MerchantStock;
import com.example.capstone1.Service.MerchantStockServ;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cap/merstock")
@RequiredArgsConstructor
public class MerchantStockController {

        private final MerchantStockServ merchantStockServ;

        //Get
        @GetMapping("/get")
    public ResponseEntity getMerchantStocks(){
    return ResponseEntity.status(HttpStatus.OK).body(merchantStockServ.getMerchantStocks());
    }


    //add
    @PostMapping("/add")
    public ResponseEntity addMerchantStocks(@Valid @RequestBody MerchantStock merchantStock, Errors errors){
            if (errors.hasErrors()){
                String message=errors.getFieldError().getDefaultMessage();
                return  ResponseEntity.status(HttpStatus.OK).body(message);
            }
            merchantStockServ.addMerchantStocks(merchantStock);
            return ResponseEntity.status(HttpStatus.OK).body("Successfully  added :) ");
    }



    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updMerchantStocks(@PathVariable String id,@Valid @RequestBody MerchantStock merchantStock,Errors errors){
            if (errors.hasErrors()){
                String message=errors.getFieldError().getDefaultMessage();
                return  ResponseEntity.status(HttpStatus.OK).body(message);
            }
            boolean isUpdate=merchantStockServ.updMerchantStocks(id,merchantStock);
            if (isUpdate)
                return ResponseEntity.status(HttpStatus.OK).body(" Successfully update :)");
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry NOT_FOUND!!  :(  \n");
        }




       //Delete
        @DeleteMapping("/delete/{id}")
    public ResponseEntity delCategories(@PathVariable String id){

            boolean isDelete=merchantStockServ.delMerchantStocks(id);
            if (isDelete)
                return ResponseEntity.status(HttpStatus.OK).body("Successfully Deleted :) ");
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry Not Found!! :( ");
        }



//
//        @PostMapping("/addStock/{id}/{productid}/{merchantid}")
//    public ResponseEntity addStockToMerchant(@PathVariable String id,@PathVariable String productid,@PathVariable String merchantid,@Valid @RequestParam int stock,Errors errors) {
//        if (errors.hasErrors()){
//            String message=errors.getFieldError().getDefaultMessage();
//            return  ResponseEntity.status(HttpStatus.OK).body(message);
//        }
//        merchantStockServ.addStockToMerchant(id, productid, merchantid, stock);
//
//        return ResponseEntity.status(HttpStatus.OK).body("Successfully added stocks to the merchant stock :)");
//    }

    //    @PostMapping("/addStock/")
//    public ResponseEntity addStockToMerchant(@Valid @RequestBody MerchantStock request, Errors errors) {
//        if (errors.hasErrors()) {
//            String message = errors.getFieldError().getDefaultMessage();
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
//        }
//
//        String id;
//        merchantStockServ.addStockToMerchant(id, request.getProductid(), request.getMerchantid(), request.getStock());
//
//        return ResponseEntity.status(HttpStatus.OK).body("Successfully added stocks to the merchant stock :)");
//    }




//    @PostMapping("/addStock")
//                                                //@Valid@RequestParam String id
//    public ResponseEntity addStockToMerchant( @Valid@RequestParam String productid,@Valid @RequestParam String merchantid,@Valid @RequestParam int stock,Errors errors) {
//        if (errors.hasErrors()){
//            String message=errors.getFieldError().getDefaultMessage();
//            return  ResponseEntity.status(HttpStatus.OK).body(message);
//        }
//        String id = "1020405004";
//        merchantStockServ.addStockToMerchant(id, productid, merchantid, stock);
//
//        return ResponseEntity.status(HttpStatus.OK).body("Successfully added stocks to the merchant stock :)");
//    }




    @PostMapping("/addStock/")
                                                //@Valid@RequestParam String id
    public ResponseEntity addStockToMerchant( @RequestBody String productid, @RequestBody String merchantid, @RequestBody int stock) {

        String id = "1020405003";
        merchantStockServ.addStockToMerchant(id, productid, merchantid, stock);

        return ResponseEntity.status(HttpStatus.OK).body("Successfully added stocks to the merchant stock :)");
    }





//    @PostMapping("/addStock")
//    //@Valid@RequestParam String id
//    public ResponseEntity addStockToMerchant(@Valid@RequestBody String id ,@Valid@RequestBody String productid,@Valid @RequestBody String merchantid,@Valid @RequestBody int stock,Errors errors) {
//        if (errors.hasErrors()){
//            String message=errors.getFieldError().getDefaultMessage();
//            return  ResponseEntity.status(HttpStatus.OK).body(message);
//        }
//        String id = "1020405004";
//        merchantStockServ.addStockToMerchant(id, productid, merchantid, stock);
//
//        return ResponseEntity.status(HttpStatus.OK).body("Successfully added stocks to the merchant stock :)");
//    }













//    @PostMapping("/addStock")
//                                                //@Valid@RequestParam String id
//    public ResponseEntity addStockToMerchant( @Valid@RequestParam(value="1020304221") String productid,@Valid @RequestParam(value = "1020304001") String merchantid,@Valid @RequestParam(value = "10") int stock,Errors errors) {
//        if (errors.hasErrors()){
//            String message=errors.getFieldError().getDefaultMessage();
//            return  ResponseEntity.status(HttpStatus.OK).body(message);
//        }
//        String id = "1020405004";
//        merchantStockServ.addStockToMerchant(id, productid, merchantid, stock);
//
//        return ResponseEntity.status(HttpStatus.OK).body("Successfully added stocks to the merchant stock :)");
//    }





}
