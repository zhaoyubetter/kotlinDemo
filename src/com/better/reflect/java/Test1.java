package com.better.reflect.java;

/**
 * 被动類初始化
 * from
 * http://blog.csdn.net/zhangliangzi/article/details/51319033
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        // 1. 訪問父類中的靜態成員 被動引用的例子1
        // System.out.println(SubClass.value);

        // 2.数组来引用类，不会触发类的初始化，因为是数组new，而类没有被new，所以没有触发任何“主动引用”条款，属于“被动引用”
        // SuperClass[] test = new SuperClass[10];

        // 3.静态常量在编译阶段就会被存入调用类的常量池中，不会引用到定义常量的类，这是一个特例，需要特别记忆，不会触发类的初始化！
        System.out.println(ConstClass.HELLOWORLD);
    }

    static class ConstClass {
        static {
            System.out.println("常量类初始化！");
        }

        public static final String HELLOWORLD = "hello world!";
    }
}
