package com.ai.android_modules.mvvm.viewmodel;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ai.android_modules.mvvm.Callback;
import com.ai.android_modules.mvvm.model.Product;
import com.ai.android_modules.mvvm.model.ProductsRepository;

public class ProductsViewModel extends ViewModel {

    private MutableLiveData<ObservableArrayList<Product>> listMutableLiveData;
    private MutableLiveData<Boolean> loading;

    public ProductsViewModel(){
        listMutableLiveData = new MutableLiveData<>();
        loading = new MutableLiveData<>();
        getProductsInfo();
    }

    public void getProductsInfo(){
        loading.setValue(true);
        ProductsRepository.getProductsRepository().getProductsFromLocal(new Callback<ObservableArrayList<Product>>() {
            @Override
            public void onSuccess(ObservableArrayList<Product> products) {
                loading.setValue(false);
                listMutableLiveData.setValue(products);
            }

            @Override
            public void onFail(String msg) {
                loading.setValue(false);
                listMutableLiveData.setValue(null);
            }
        });

        ProductsRepository.getProductsRepository().getProductsFromServer(new Callback<ObservableArrayList<Product>>() {
            @Override
            public void onSuccess(ObservableArrayList<Product> products) {
                loading.setValue(false);
                listMutableLiveData.setValue(products);
            }

            @Override
            public void onFail(String msg) {
                loading.setValue(false);
                listMutableLiveData.setValue(null);
            }
        });
    }

    public LiveData<ObservableArrayList<Product>> getProductsData(){
        return listMutableLiveData;
    }

    public LiveData<Boolean> getLoading(){
        return loading;
    }
}
