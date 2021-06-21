package com.ai.android_modules;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.ai.android_modules.data_binding.DataBindingTestActivity;
import com.ai.android_modules.databinding.ActivityMainBinding;
import com.ai.android_modules.mvvm.view.ProductsActivity;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setModules(new ModulesBean("dataBinding", "mvvM"));
        activityMainBinding.setOnClickPresenter(new OnClickPresenter());
    }

    public class OnClickPresenter {

         public void toDataBinding(View view){
             DataBindingTestActivity.launch(MainActivity.this);
         }

         public void toMvvM(View view){
             ProductsActivity.launch(MainActivity.this);
         }

    }
}