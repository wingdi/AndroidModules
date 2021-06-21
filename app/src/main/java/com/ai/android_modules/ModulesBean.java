package com.ai.android_modules;

public class ModulesBean {

    private String dataBinding;
    private String MvvM;


    public ModulesBean(String dataBinding, String mvvM) {
        this.dataBinding = dataBinding;
        MvvM = mvvM;
    }

    public String getDataBinding() {
        return dataBinding;
    }

    public void setDataBinding(String dataBinding) {
        this.dataBinding = dataBinding;
    }

    public String getMvvM() {
        return MvvM;
    }

    public void setMvvM(String mvvM) {
        MvvM = mvvM;
    }
}

