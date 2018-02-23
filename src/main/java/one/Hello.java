package one;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoyu on 2017/5/27.
 */
public class Hello {
    void hello() {

    }

    interface Source<T> {
        T next();
    }

    void demo(Source<String> strs) {
        // 需改成：Source<? extends Object> objs = strs;
        //Source<Object> objs = strs;
    }


    ///////////////////////
    class Anim {
    }

    class FlyAnim extends Anim {
    }

    class Bird extends FlyAnim {
    }

    class RedBird extends Bird {
    }

    void test() {
        List<? extends Anim> extendAnims = new ArrayList<Bird>();
        //extendAnims.add(new Bird());        // 编译错误
        //extendAnims.add(new RedBird());

        List<? super FlyAnim> superAnims = new ArrayList<>();
        superAnims.add(new Bird());        // 正常编译
        // 以下，这里的 super 不是指父类的意思，而表示是，可以父类，必须可以放其子类，多态
        //superAnims.add(new Anim());

        List<? super CharSequence> tests = new ArrayList<>();
        tests.add(new StringBuffer("a"));

    }
}
