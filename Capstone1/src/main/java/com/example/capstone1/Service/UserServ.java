package com.example.capstone1.Service;

import com.example.capstone1.Model.MerchantStock;
import com.example.capstone1.Model.Product;
import com.example.capstone1.Model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

@Getter
@Setter
@Service
public class UserServ {
    //Get
    ArrayList<User>users=new ArrayList<>();


    //Add
    public  void addUsers(User user){
        users.add(user);
    }



    //update
    public boolean updUsers(String id,User user){
        for (int i = 0; i <users.size() ; i++) {
            if (users.get(i).getId().equals(id)){
                users.set(i,user);
                return true;
            }
        }

    return false;
    }


    //Delete
    public boolean delUsers(String id){
        for (int i = 0; i <users.size() ; i++) {
            if (users.get(i).getId().equals(id)){
                users.remove(i);
                return true;
            }
        }
        return false;
    }

    public Optional<User> getUserById(String id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public boolean isValidUser(String userId) {
        return users.stream().anyMatch(user -> user.getId().equals(userId));
    }







    public Optional<User> saveUser(User user) {
        return Optional.of(user);
    }



}

