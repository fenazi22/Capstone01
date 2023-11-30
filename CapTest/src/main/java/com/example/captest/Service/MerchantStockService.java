package com.example.captest.Service;

import com.example.captest.Model.Merchant;
import com.example.captest.Model.MerchantStock;
import com.example.captest.Model.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {
    
    ArrayList<MerchantStock>merchantStocks=new ArrayList<>();


    public ArrayList<MerchantStock> getmerchantStock(){
        return merchantStocks;
    }

    public char addmerchantStock(MerchantStock merchantStock){
        for (int i = 0; i <merchantStocks.size() ; i++) {
            if (merchantStocks.get(i).getId().equals(merchantStock.getId()) || merchantStocks.get(i).getProductid().equals(merchantStock.getProductid()) || merchantStocks.get(i).getMerchantid().equals(merchantStock.getMerchantid()));
            return 'a';
        }
        if (merchantStock.getId()==null || merchantStock.getStock()==0 || merchantStock.getProductid()==null || merchantStock.getMerchantid()==null){
            return 'b';
        }else {
            merchantStocks.add(merchantStock);
            return 'c';

        }
    }

    public char updatemerchantStock(String id , MerchantStock merchantStock){
        for (int i = 0; i <merchantStocks.size() ; i++) {
            if (merchantStocks.get(i).getId().equals(id)){
                merchantStocks.set(i,merchantStock);
                return 'a';
            }else{
                return 'b';
            }
        }
        return 'c';
    }



    public char deletemerchantStock(String id){
        for (int i = 0; i <merchantStocks.size() ; i++) {
            if (merchantStocks.get(i).getId().equals(id)){
                merchantStocks.remove(i);
                return 'a';
            }else {
                return 'b';
            }
        }
        return 'c';
    }
    









}
