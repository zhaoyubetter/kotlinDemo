package fanxing;

import java.util.*;

/**
 * 参考：https://www.jianshu.com/p/3a8622525902
 * Created by zhaoyu1 on 2017/7/7.
 */
public class JavaTest {
    public static void main(String[] args) {

        List<CharSequence> strList = new ArrayList<>();

        // 报错,Java 中的泛型不允许这样操作
        // List<Object> objList = strList;

        //objList.add(5);

        // 以下没问题
        // 签名为；addAll(Collection<? super T> c
        Collections.addAll(strList, "aa", "bb", "cc");
        //
        Collections.addAll(strList, "");

        /// ============ 其他例子 Java 泛型不支持继承
        //Plate<Fruit> p=new Plate<Apple>(new Apple());  // 装苹果的盘子”无法转换成“装水果的盘子”。
    }

    static class Fruit {
    }

    static class Apple extends Fruit {
    }

    static class Plate<T> {
        private T item;

        public Plate(T t) {
            item = t;
        }

        public void set(T t) {
            item = t;
        }

        public T get() {
            return item;
        }
    }

    <T> void method(List<T> list) {
        for (T t : list) {
        }
    }

}
