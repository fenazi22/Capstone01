package com.example.captest.Controller;

import com.example.captest.Model.Category;
import com.example.captest.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/capt/cate")
@RequiredArgsConstructor
public class CategoryController {
   private  final CategoryService categoryService;
    @GetMapping("/get")
    public ResponseEntity getCategory(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategories());
    }

    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody Category category, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        char isAdd=categoryService.addCategory(category);
        if (isAdd=='a'){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("your use ID ,name before");
        }
        if (isAdd=='b'){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please Input ID and name");
        }
        if (isAdd=='s'){
            return ResponseEntity.status(HttpStatus.OK).body("Add Successfully ");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
    }

@PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable String id, @Valid @RequestBody Category category,Errors errors){
    if (errors.hasErrors()){
        String message=errors.getFieldError().getDefaultMessage();
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    char isUpdate= categoryService.updateCategory(id, category);
    if (isUpdate=='a'){
        return ResponseEntity.status(HttpStatus.OK).body("Successfully update ");
    }
    if (isUpdate=='b'){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID not found");
    }

    return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
    }


    @DeleteMapping("/delete/{id}")
    public  ResponseEntity deleteCategory(@PathVariable String id){
        char isDelete= categoryService.deleteCategory(id);
        if (isDelete=='a'){return ResponseEntity.status(HttpStatus.OK).body("Successfully Delete");}
        if (isDelete=='b'){return ResponseEntity.status(HttpStatus.OK).body("cannot  found ID");}
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
    }

}
