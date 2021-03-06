package fanxing;

import java.util.*;

/**
 * Created by zhaoyu1 on 2018/1/3.
 */
public class JavaTest6 {

    void method2() {
        List<JavaTest.Fruit> list = new ArrayList<>();
        list.add(new JavaTest.Apple());
        final JavaTest.Apple fruit = (JavaTest.Apple) list.get(0);

        method(list);
    }

    <T> void method(List<T> list) {
        for (T t : list) {
        }
    }

    // 泛型的显示声明 this.<>
    // 异构容器 Map<Class<?>, Object>

    // 泛型包括：泛型的申明与使用

    public static void main(String[] args) {
        // ? extends T, 与 T的区别

        Map<Set<?>, Object> map = new HashMap<>();
        map.put(new HashSet<String>(), "aa");
        map.put(new HashSet<Integer>(), 11);
    }

}
