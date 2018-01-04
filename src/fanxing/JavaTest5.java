package fanxing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 参考：https://www.jianshu.com/p/3a8622525902
 * Created by zhaoyu1 on 2017/7/7.
 */
public class JavaTest5 {
    public static void main(String[] args) {
        List<CharSequence> strList = new ArrayList<>();
        // 报错,Java 中的泛型不允许这样操作
        // List<Object> objList = strList;
    }

    static void method(List<String> list) {
        // List<Object> tmpList = list;  // ERROR
    }
}
