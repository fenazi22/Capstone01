package com.example.captest.Service;

import com.example.captest.Model.Merchant;
import com.example.captest.Model.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {

    ArrayList<Merchant>merchants=new ArrayList<>();

    public ArrayList<Merchant> getMerchant(){
        return merchants;
    }

    public char addMerchant(Merchant merchant){
        for (int i = 0; i <merchants.size() ; i++) {
            if (merchants.get(i).getId().equals(merchant.getId()) || merchants.get(i).getName().equals(merchant.getName()));
            return 'a';
        }
     if (merchant.getId()==null || merchant.getName()==null ){
         return 'b';
        }else {
         merchants.add(merchant);
         return 'c';

     }
}

    public char updateMerchant(String id , Merchant merchant){
        for (int i = 0; i <merchants.size() ; i++) {
            if (merchants.get(i).getId().equals(id)){
                merchants.set(i,merchant);
                return 'a';
            }else{
                return 'b';
            }
        }
        return 'c';
    }



    public char deleteMerchant(String id){
        for (int i = 0; i <merchants.size() ; i++) {
            if (merchants.get(i).getId().equals(id)){
                merchants.remove(i);
                return 'a';
            }else {
                return 'b';
            }
        }
        return 'c';
    }




}
