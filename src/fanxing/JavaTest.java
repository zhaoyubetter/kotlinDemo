package fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoyu1 on 2017/7/7.
 */
public class JavaTest {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        List<Object> objList = new ArrayList<>();

        objList.add(5);

        objList.addAll(strList);

    }
}
