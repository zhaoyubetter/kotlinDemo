package fanxing;

/**
 * 参考：https://www.jianshu.com/p/3a8622525902
 * Created by zhaoyu1 on 2017/7/7.
 */
public class JavaTest3 {
    public static void main(String[] args) {
       // ===== Java上下界通配符的副作用
        // 上界 <? extends T> 只能取，不能存
        Plate<? extends Fruit> p = new Plate<>(new Apple());

        // 取出来的东西，只能是fruit或者fruit的父
        final Fruit fruit = p.get();
        System.out.println(fruit);
        final Object o = p.get();
        // final Apple apple = p.get();  ERROR

        // 为什么这样子呢，请思考？ "? 与 T" 到底是什么意思


        // 不能存，存就出错
       // p.set(new Apple());


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
