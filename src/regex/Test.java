package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhaoyu1 on 2017/6/1.
 */
public class Test {
    public static void main(String[] args) {
        String str = "12.345-6.a";
        //System.out.println(str.split("\\."));

        final String path = "/Users/better/android/kotlin-book.pdf";

        final Pattern pattern = Pattern.compile("(.+)/((.+)\\.(.+))");
        final Matcher matcher = pattern.matcher(path);
        if (matcher.find()) {
            System.out.println(matcher.group(0));       // 整个串
            System.out.println(matcher.group(1));       // (.+)
            System.out.println(matcher.group(2));       // ((.+)\\.(.+))
            System.out.println(matcher.group(3));       // (.+)
            System.out.println(matcher.group(4));       // (.+)
        }
    }
}
