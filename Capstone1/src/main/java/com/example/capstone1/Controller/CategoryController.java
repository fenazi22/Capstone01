package com.example.capstone1.Controller;

import com.example.capstone1.Model.Category;
import com.example.capstone1.Service.CategoryServ;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cap/cate")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryServ categoryServ;


    //get
@GetMapping("/get")
    public ResponseEntity getCategories(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryServ.getCategories());
    }


    //add
    @PostMapping("/add")
    public ResponseEntity addCategories(@Valid @RequestBody Category category, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }

        categoryServ.addCategories(category);
        return  ResponseEntity.status(HttpStatus.OK).body("Successfully added ^_^ ");
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updCategories(@PathVariable String id,@Valid @RequestBody Category category,Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }

        boolean isUpdate=categoryServ.updCategories(id,category);
        if (isUpdate){
            return ResponseEntity.status(HttpStatus.OK).body("Successfully Update ^_^ ");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry NOT_FOUND!!   !_! \n");

        }
    }



//Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delCategories(@PathVariable String id){
        boolean isDelete=categoryServ.delCategories(id);
        if (isDelete){
            return ResponseEntity.status(HttpStatus.OK).body("Successfully Delete ^_^");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry NOT_FOUND!!  !_!");
        }

    }


}
