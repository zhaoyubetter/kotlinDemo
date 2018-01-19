package fanxing;

import java.util.ArrayList;
import java.util.List;

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
}
