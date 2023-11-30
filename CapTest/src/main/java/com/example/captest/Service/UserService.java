package com.example.captest.Service;

import com.example.captest.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

ArrayList<User>users=new ArrayList<>();

public ArrayList<User>getUsers(){
    return users;
}



    public char addUsers(User user) {
        for (int i = 0; i <users.size() ; i++) {
            if (users.get(i).getId().equals(user.getId())|| users.get(i).getUsername().equals(user.getUsername()) || users.get(i).getEmail().equals(user.getEmail()))
                return 'k';
        }
         if (user.getRole() == null || user.getEmail() == null || user.getPassword() == null || user.getUsername() == null || user.getBalance() == 0) {
            return 'b';
        }else  {
            users.add(user);
            return 'a';
        }



    }


    public char updateUser(String id ,User user){
        for (int i = 0; i <users.size() ; i++) {
            if (users.get(i).getId().equals(id)){
                users.set(i,user);
                return 'a';
            }else{
                return 'b';
            }
        }
return 'c';
}



public char deleteUser(String id){
    for (int i = 0; i <users.size() ; i++) {
        if (users.get(i).getId().equals(id)){
            users.remove(i);
            return 'a';
        }else {
            return 'b';
        }
    }
return 'c';
}


}
