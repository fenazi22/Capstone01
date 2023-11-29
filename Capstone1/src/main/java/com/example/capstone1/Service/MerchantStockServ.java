package com.example.capstone1.Service;

import com.example.capstone1.Model.Merchant;
import com.example.capstone1.Model.MerchantStock;
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
public class MerchantStockServ {

    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Merchant> merchants = new ArrayList<>();
    private ArrayList<MerchantStock> merchantStocks = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    //get
    public ArrayList<MerchantStock> getMerchantStocks() {
        return merchantStocks;
    }


    //add
    public void addMerchantStocks(MerchantStock merchantStock) {
        merchantStocks.add(merchantStock);
    }


    //UPDATE
    public boolean updMerchantStocks(String id, MerchantStock merchantStock) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId().equals(id)) {
                merchantStocks.set(i, merchantStock);
                return true;

            }
        }
        return false;
    }


    //Delete
    public boolean delMerchantStocks(String id) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId().equals(id)) {
                merchantStocks.remove(i);
                return true;
            }
        }
        return false;

    }


//    public void addStockToMerchant(String id, String productid, String merchantid, int stock) {
//
//        if (id == null || productid == null || merchantid == null || stock <= 0) {
//            return;
//        }
//
//
//        Product foundProduct = null;
//        for (Product p : products) {
//            if (p.getId().equals(productid)) {
//                foundProduct = p;
//                break;
//            }
//        }
//
//
//
//        Merchant foundMerchant = null;
//        for (Merchant m : merchants) {
//            if (m.getId().equals(merchantid)) {
//                foundMerchant = m;
//                break;
//            }
//        }
//
//
//
//        if (foundProduct != null && foundMerchant != null) {
//            MerchantStock foundMerchantStock = null;
//            for (MerchantStock ms : merchantStocks) {
//                if (ms.getProductid().equals(productid) && ms.getMerchantid().equals(merchantid)) {
//                    foundMerchantStock = ms;
//                    break;
//                }
//            }
//
//
//
//            if (foundMerchantStock != null) {
//                foundMerchantStock.setStock(foundMerchantStock.getStock() + stock);
//            } else {
//                MerchantStock newStock = new MerchantStock(id, productid, merchantid, stock);
//                merchantStocks.add(newStock);
//            }
//        }
//
//
//    }

public void addToStocks(Product productid,Merchant merchantid,int amount ){




        for (int i = 0; i <merchantStocks.size() ; i++) {
        if (merchantStocks.get(i).getProductid().equals(productid))
        products.add(i,productid);

        }

    for (int i = 0; i <merchantStocks.size() ; i++) {

    }




}




    public Optional<MerchantStock> getMerchantStocks(String productId, String merchantId) {
        return merchantStocks.stream()
                .filter(stock -> stock.getProductid().equals(productId) && stock.getMerchantid().equals(merchantId))
                .findFirst();
    }

    public boolean isValidProductAndMerchant(String productId, String merchantId) {
        return merchantStocks.stream().anyMatch(stock ->
                stock.getProductid().equals(productId) && stock.getMerchantid().equals(merchantId));
    }




    public Optional<MerchantStock> saveMerchantStock(MerchantStock merchantStock) {
        return Optional.of(merchantStock);
    }

    }
