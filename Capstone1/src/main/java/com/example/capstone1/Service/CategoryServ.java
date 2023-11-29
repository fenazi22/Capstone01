package com.example.capstone1.Service;

import com.example.capstone1.Model.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Getter
@Setter
@Service
public class CategoryServ {
    ArrayList<Category>categories=new ArrayList<>();




    //get
    public ArrayList<Category> getCategories() {
        return categories;
    }

    //add
    public void addCategories(Category category) {
        categories.add(category);
    }


    //update
    public boolean updCategories(String id,Category category){
        for (int i = 0; i <categories.size() ; i++) {
            if (categories.get(i).getId().equals(id)){
                categories.set(i,category);
                return  true;
            }
        }
        return false;
    }


    //delete
    public boolean delCategories(String id){
        for (int i = 0; i <categories.size() ; i++) {
            if (categories.get(i).getId().equals(id)){
                categories.remove(i);
                return  true;
            }
        }
        return false;
    }

}
