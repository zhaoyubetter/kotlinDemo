package fanxing;

/**
 * 参考：https://www.zhihu.com/question/20400700
 * Created by zhaoyu1 on 2017/7/7.
 */
public class JavaTest4 {
    public static void main(String[] args) {
       // ===== Java上下界通配符的副作用
        // 上界 <? extends T> 只能取，不能存
        Plate<? extends Fruit> p = new Plate<>(new Apple());

        // 取出来的东西，只能是fruit或者fruit的父
        final Fruit fruit = p.get();
        System.out.println(fruit);
        final Object o = p.get();
        // final Apple apple = p.get();  ERROR

        // 为什么这样子呢，请思考？ "? 与 T" 到底是什么意
        // 不能存，存就出错
       // p.set(new Apple());


        //------------------------------------------------------------------------------------
        // 下界 <? super T> 可存，但往外取时对象只能存放在Object中
        Plate<? super Fruit> p2 = new Plate<>(new Apple());
        p2.set(new Apple());
        p2.set(new Banana());
        final Object object = p2.get();  // 取只能存在Object中
        System.out.println(object);

        // 以下错误
        // Fruit fruit1 = p2.get();  // ERROR

        // 思考时间，为什么要这么做


        // ===== 结论：PECS原则
        // (Producer Extends Consumer Super)
        // 1. 频繁往外读，适合上界 extends
        // 2. 频繁插入的，适合下界 super
    }

    // lev 1
    static class Food{}

    // lev 2
    static class Fruit extends Food {}
    static class Meat extends Food {}

    // lev 3
    static class Apple extends Fruit {}
    static class Banana extends Fruit{}
    static class Pork extends Meat {}
    static class Beef extends Meat {}

    // lev 4
    static class RedApple extends Apple {}
    static class GreenApple extends Apple {}

    // 盘子类
    static class Plate<T> {
        private T item;
        public Plate(T t) {item = t;}
        public void set(T t) {item = t;}
        public T get() {return item;}
    }
}
