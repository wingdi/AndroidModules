package com.ai.android_modules.data_binding;

public class Product {

    private String name;
    private String desc;

    public Product(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
