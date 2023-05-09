package test;

import javax.xml.transform.Source;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 雨天留恋
 * @date 2023-03-10 20:38
 */
class MainTest {
    MainTest() {
        System.out.println("---------MainTest被初始化-----");
    }
    public MainTest InnerTest(int n) {
        System.out.println(n);
        return this;
    }

    class Builder1 {
         static MainTest mainTest = new MainTest();
         Builder1() {
             System.out.println("----被加载了-------");
             // mainTest = new MainTest();
         }

        public MainTest build() {
            return mainTest;
        }
    }
    static class Builder2 {
        static MainTest mainTest = new MainTest();
        Builder2() {
            System.out.println("----被加载了-------");
            // mainTest = new MainTest();
        }

        public MainTest build() {
            return mainTest;
        }
    }

}
class MyMainClass {
    public static void main(String[] args) {
        MainTest test1 = new MainTest().new Builder1().build();
        System.out.println(test1);
        MainTest test2 = new MainTest.Builder2().build();
        System.out.println(test2);
        MainTest test = new MainTest.Builder2().build();
        System.out.println(test);
        System.out.println(test1 == test2);
    }
}