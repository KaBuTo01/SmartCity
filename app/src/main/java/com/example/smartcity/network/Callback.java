package com.example.smartcity.network;

/**
 * @ClassName Callback
 * @Author name
 * @Date 2023/3/11
 * @Description
 */
public interface Callback {
    void success(String request);
    void fail(Exception e);
}
