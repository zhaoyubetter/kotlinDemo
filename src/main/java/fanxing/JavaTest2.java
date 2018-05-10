package fanxing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 参考：https://www.jianshu.com/p/3a8622525902
 * Created by zhaoyu1 on 2017/7/7.
 */
public class JavaTest2 {
    public static void main(String[] args) {

        /**
         * @see JavaTest
         */
        /// ============ 其他例子 Java 泛型不支持继承
        //Plate<Fruit> p=new Plate<Apple>(new Apple());  // 装苹果的盘子”无法转换成“装水果的盘子”。

        // ===》改成 (啥水果都能放的盘子) 加入extends
        Plate<? extends Fruit> p = new Plate<>(new Apple());
//        p.set(new Banana()); //报错
    }

    static class Fruit {
    }

    static class Apple extends Fruit {
    }

    static class Banana extends Fruit {}

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
}
