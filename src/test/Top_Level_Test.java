package test;


import java.util.ArrayList;
import java.util.List;

import top_level.JoinPropKt;
import top_level.StringFunctions;

/**
 * Created by zhaoyu on 2017/5/31.
 */
public class Top_Level_Test {

    public static void main(String... a) {
        List<String> items = new ArrayList<>();
        items.add("one");
        items.add("two");
        items.add("three");
        String str = StringFunctions.joinToString(items, ", ", "(", ")");

        System.out.println(str);

        JoinPropKt.getOpCount();

        System.out.println("====");

        System.out.println(StringFunctions.lastChar("better"));

    }
}
