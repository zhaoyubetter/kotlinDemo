package com.better.fanxing;

/**
 * Created by zhaoyu on 2018/2/3.
 */
public class JavaTest {

    public  <T extends Number> void test(T t) {
    }
    public void other() {
        test(1);
    }
}
