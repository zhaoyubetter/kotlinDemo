package com.better.fanxing;

import three.Num;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhaoyu on 2018/2/3.
 */
public class JavaTest {

    public  <T extends Number> void test(T t) {
    }
    public void other() {
        test(1);
    }

    public <T> void xx(T a) {}

    public static void main(String... ar) {
        JavaTest a = new JavaTest();
    }


    public <T extends Number> void test2(List<T> collection) {

    }
}
