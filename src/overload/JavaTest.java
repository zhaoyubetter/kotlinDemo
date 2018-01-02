package overload;

/**
 * Created by zhaoyu on 2017/8/10.
 */
public class JavaTest {

    static class BaseClass {
        public BaseClass() {
            print("base print");
        }

        void print(String str) {
            System.out.println("base print value " + str);
        }
    }

    static class ChildClass extends BaseClass {
        final String name;

        public ChildClass() {
            super();
            name = "child!!";
        }

        @Override
        void print(String str) {
            super.print(str);
            System.out.println("child print value " + name);
        }
    }

    public static void main(String... aa) {
        ChildClass item = new ChildClass();
        item.print("dddd");
    }
}


