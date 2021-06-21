package com.ai.android_modules.mvvm.view;

import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.ai.android_modules.R;
import com.ai.android_modules.databinding.ItemMvvmProductBinding;
import com.ai.android_modules.mvvm.model.Product;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

public class ProductListAdapter extends BaseQuickAdapter<Product, ProductListAdapter.ProductItemViewHolder> {

    public ProductListAdapter() {
        super(R.layout.item_mvvm_product);
    }

    @Override
    protected void convert(@NotNull ProductItemViewHolder productItemViewHolder, Product product) {
        productItemViewHolder.getItemProductBinding().setProduct(product);
        productItemViewHolder.getItemProductBinding().executePendingBindings();
    }

    protected static class ProductItemViewHolder extends BaseViewHolder {
        ItemMvvmProductBinding binding;
        public ProductItemViewHolder(@NotNull View view) {
            super(view);
            binding = DataBindingUtil.bind(view);

        }

        public ItemMvvmProductBinding getItemProductBinding() {
            return binding;
        }
    }
}
