package com.example.captest.Service;

import com.example.captest.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {


    ArrayList<Product> products=new ArrayList<>();

    public ArrayList<Product> getProduct(){
        return products;
    }

    public char addProduct(Product product){
        for (int i = 0; i <products.size() ; i++) {
            if (products.get(i).getId().equals(product.getId()) || products.get(i).getName().equals(product.getName()) || products.get(i).getCategoryID().equals(product.getCategoryID()));
            return 'a';
        }
        if (product.getId()==null || product.getPrice()==0 || product.getCategoryID()==null || product.getName()==null){
            return 'b';
        }else {
            products.add(product);
            return 'c';

        }
    }

    public char updateProduct(String id , Product product){
        for (int i = 0; i <products.size() ; i++) {
            if (products.get(i).getId().equals(id)){
                products.set(i,product);
                return 'a';
            }else{
                return 'b';
            }
        }
        return 'c';
    }



    public char deleteProduct(String id){
        for (int i = 0; i <products.size() ; i++) {
            if (products.get(i).getId().equals(id)){
                products.remove(i);
                return 'a';
            }else {
                return 'b';
            }
        }
        return 'c';
    }



}
