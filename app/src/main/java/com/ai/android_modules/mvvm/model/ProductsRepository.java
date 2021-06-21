package com.ai.android_modules.mvvm.model;

import androidx.databinding.ObservableArrayList;

import com.ai.android_modules.mvvm.Callback;

public class ProductsRepository {

    private static ProductsRepository productsRepository;

    public static ProductsRepository getProductsRepository(){
        if(productsRepository == null){
            productsRepository = new ProductsRepository();
        }
        return productsRepository;
    }

    public void getProductsFromServer(Callback<ObservableArrayList<Product>> callback){

    }

    // 从本地数据库获取
    public void getProductsFromLocal(Callback<ObservableArrayList<Product>> callback){
        ObservableArrayList<Product> products = new ObservableArrayList<>();
        products.add(new Product("显卡v100","牛"));
        products.add(new Product("公牛插座","牛逼"));
        products.add(new Product("电线杆","给力"));
        products.add(new Product("玫瑰","带刺的"));
        callback.onSuccess(products);
    }

    private void saveProductsToLocal(ObservableArrayList<Product> products){

    }




}
