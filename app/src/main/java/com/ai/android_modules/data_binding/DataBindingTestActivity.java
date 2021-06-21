package com.ai.android_modules.data_binding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ai.android_modules.R;
import com.ai.android_modules.databinding.ActivityDatabindingBinding;
import com.ai.android_modules.databinding.ItemProductBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

//绑定布局生成的类命名规则：xml文件名称 正向驼峰式+Binding

/**
 * 解决了Activity中声明xml中的控件，但是还没有解决创建Adapter/ViewHolder
 */

public class DataBindingTestActivity extends AppCompatActivity {

     private  ProductListAdapter mAdapter;
     ActivityDatabindingBinding activityDatabindBinding;

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, DataBindingTestActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDatabindBinding = DataBindingUtil.setContentView(this,R.layout.activity_databinding);
        activityDatabindBinding.rvProductList.setLayoutManager(new GridLayoutManager(this,4));
        mAdapter = new ProductListAdapter();
        mAdapter.setNewInstance(getProductList());
        activityDatabindBinding.rvProductList.setAdapter(mAdapter);
        activityDatabindBinding.setProduct(new Product("雪糕","好吃"));
        activityDatabindBinding.setClickPresenter(new ClickPresenter());
    }

    private List<Product> getProductList(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("显卡v100","牛"));
        products.add(new Product("公牛插座","牛逼"));
        products.add(new Product("电线杆","给力"));
        products.add(new Product("玫瑰","带刺的"));
        return products;
    }

     public class ClickPresenter {

        public void addProduct(View view) {
            Toast.makeText(DataBindingTestActivity.this, "添加产品", Toast.LENGTH_SHORT).show();
            mAdapter.addData(new Product("显卡1","Lv5"));
        }

        public void removeProduct(View view) {
            Toast.makeText(DataBindingTestActivity.this, "removeUser", Toast.LENGTH_SHORT).show();
            mAdapter.remove(0);
        }
    }

    private static class ProductListAdapter extends BaseQuickAdapter<Product, ProductItemViewHolder> {

        public ProductListAdapter() {
            super(R.layout.item_product);
        }

        @Override
        protected void convert(@NonNull ProductItemViewHolder holder, Product product) {
            // 精髓所在1，不需要去一个个setText等等
            holder.getItemProductBinding().setProduct(product);
            holder.getItemProductBinding().executePendingBindings();

            //当获取的DataBinding不是具体类时，只是ViewDataBinding，那就要使用setVariable了
//            holder.getViewDataBinding().setVariable(BR.user, user);
//            holder.getViewDataBinding().executePendingBindings();
        }
    }

    private static class ProductItemViewHolder extends BaseViewHolder {

        private final ItemProductBinding binding;
//        private final ViewDataBinding binding2;

        public ProductItemViewHolder(View view) {
            super(view);
            binding = DataBindingUtil.bind(view);
//            binding2 = DataBindingUtil.bind(view);
        }

        public ItemProductBinding getItemProductBinding() {
            return binding;
        }
//        public ViewDataBinding getViewDataBinding() {
//            return binding2;
//        }
    }

}