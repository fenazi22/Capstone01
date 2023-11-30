package com.example.captest.Service;

import com.example.captest.Model.Category;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class CategoryService {
    ArrayList<Category>categories=new ArrayList<>();
    public ArrayList<Category>getCategories(){
        return categories;
    }


    public char addCategory(Category category){
        for (int i = 0; i <categories.size() ; i++) {
            if (categories.get(i).getId().equals(category.getId()) || categories.get(i).getName().equals(category.getName())) {
                return 'a';
            }
        }

        if (category.getName()==null ||category.getId()==null){
            return 'b';
        }else {
            categories.add(category);
            return 's';
        }

    }

    public  char updateCategory(String id ,Category category){
        for (int i = 0; i <categories.size() ; i++) {
            if (categories.get(i).getId().equals(id)){
                categories.set(i,category);
                return 'a';
            }
            return 'b';
        }
        return 'c';
    }


    public  char deleteCategory(String id){
        for (int i = 0; i <categories.size() ; i++) {
            if (categories.get(i).getId().equals(id)){
                categories.remove(i);
                return 'a';
            }
            return 'b';
        }
        return 'c';
    }

}
