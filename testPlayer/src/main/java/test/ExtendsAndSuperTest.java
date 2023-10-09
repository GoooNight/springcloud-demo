package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 雨天留恋
 * @date 2023-07-19 10:20
 */
public class ExtendsAndSuperTest {

    public void test(List<? extends Number> list) {

    }

    public static void main(String[] args) {

        List<? extends Number> list = new ArrayList<Integer>(){{add(1);}};
        list.forEach(System.out::println);

    }
}
