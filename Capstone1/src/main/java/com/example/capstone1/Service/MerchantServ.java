package com.example.capstone1.Service;

import com.example.capstone1.Model.Merchant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Getter
@Setter
@Service
public class MerchantServ {
    ArrayList<Merchant>merchants=new ArrayList<>();



    //get
    public ArrayList<Merchant> getMerchants(){
        return merchants;
    }


    //add
    public  void addMerchants(Merchant merchant){
        merchants.add(merchant);
    }


    //update
    public  boolean updMerchants(String id,Merchant merchant){
        for (int i = 0; i <merchants.size() ; i++) {
           if (merchants.get(i).getId().equals(id)){
               merchants.set(i,merchant);
               return  true;
           }
        }
    return false;
    }


    //Delete
     public  boolean delMerchants(String id){
        for (int i = 0; i <merchants.size() ; i++) {
            if (merchants.get(i).getId().equals(id)){
                merchants.remove(i);
                return true;

            }
        }
    return false;
    }







}
