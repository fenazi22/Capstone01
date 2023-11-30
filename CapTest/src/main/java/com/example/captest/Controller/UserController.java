package com.example.captest.Controller;

import com.example.captest.Model.User;
import com.example.captest.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/capt/user")
@RequiredArgsConstructor
public class UserController {
private final UserService userService;
@GetMapping("/get")
public ResponseEntity getUsers(){
    return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
}


@PostMapping("/add")
    public ResponseEntity addUsers(@Valid@RequestBody User user, Errors errors) {
    if (errors.hasErrors()) {
        String message = errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }
    char isAdd= userService.addUsers(user);

     if (isAdd=='b'){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sorry your missing Role || Email || Password || Username ||Balance  :( ");
       }else if (isAdd=='a'){
        return ResponseEntity.status(HttpStatus.OK).body("Added ");
    }else if(isAdd=='k'){

            //extra endpoint check if yous ID or Username or Email before;
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("your use  ID , username  or Email  before  :( ");
     } else

return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found!");
}


@PutMapping("/update/{id}")
public ResponseEntity updateUser(@PathVariable String id,@Valid @RequestBody User user,Errors errors){
    if (errors.hasErrors()) {
        String message = errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    char isUpdate= userService.updateUser(id, user);
    if (isUpdate=='a'){
        return ResponseEntity.status(HttpStatus.OK).body("Successfully Updated :|");
    }
    if (isUpdate=='b'){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sorry Not found ID");
    }
    if (isUpdate=='c'){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry Not Found");
}



    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleUser(@PathVariable String id){


        char isUpdate= userService.deleteUser(id);
        if (isUpdate=='a'){
            return ResponseEntity.status(HttpStatus.OK).body("Successfully Deleted :|");
        }
        if (isUpdate=='b'){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sorry Not found ID");
        }
        if (isUpdate=='c'){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sorry Not found ID");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry Not Found");
    }



}

