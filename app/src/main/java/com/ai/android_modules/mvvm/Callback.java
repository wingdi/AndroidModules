package com.ai.android_modules.mvvm;

public interface Callback<T> {

    void onSuccess(T t);
    void onFail(String msg);
}
