package com.ai.android_modules.mvvm.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ai.android_modules.R;
import com.ai.android_modules.databinding.ActivityMvvmBinding;
import com.ai.android_modules.databinding.ItemMvvmProductBinding;
import com.ai.android_modules.mvvm.model.Product;
import com.ai.android_modules.mvvm.viewmodel.ProductsViewModel;

import java.util.ArrayList;
import java.util.List;

// 有Adapter和ViewHolder 还是相对复杂
public class ProductsActivity extends AppCompatActivity {

    private ProductsViewModel productsViewModel ;
    private ActivityMvvmBinding activityMvvmBinding;
    private ProductListAdapter mAdapter;

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, ProductsActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMvvmBinding = DataBindingUtil.setContentView(this,R.layout.activity_mvvm);
        activityMvvmBinding.setProduct(new Product("雪糕","---贼好吃"));
        activityMvvmBinding.rvProductList.setLayoutManager(new GridLayoutManager(this,4));
        productsViewModel = new ProductsViewModel();
        mAdapter = new ProductListAdapter();
        mAdapter.setNewInstance(productsViewModel.getProductsData().getValue());
        activityMvvmBinding.rvProductList.setAdapter(mAdapter);
    }

}
