package com.example.capstone1.Service;

import com.example.capstone1.Model.Product;
import com.example.capstone1.Model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Getter
@Setter
@Service
public class ProductServ {

    ArrayList<Product> products=new ArrayList<>();




    //Get
    public  ArrayList<Product> getProduct(){
        return products;
    }



    //Add
    public  void addProduct(Product product){
        products.add(product);
    }

    //update
    public boolean updProduct(String id,Product product){
        for (int i = 0; i <products.size() ; i++) {
            if (products.get(i).getId().equals(id)){
                products.set(i,product);
                return true;
            }
        }

        return false;
    }


    //Delete
    public boolean delProduct(String id){
        for (int i = 0; i <products.size() ; i++) {
            if (products.get(i).getId().equals(id)){
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    public Optional<Product> getProductById(String id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }


}
