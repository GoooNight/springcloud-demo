package test.extendTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 雨天留恋
 * @date 2023-07-26 9:44
 */
public class Animal {

    public String name;

    public void eat(HashMap map) {
        System.out.println("吃东西");
    }

    public static void main(String[] args) {
        List<Animal> list = new ArrayList<>();
        list.add(new Cat());
        list.add(new Dog());
        list.get(1).eat(new HashMap());
        list.forEach(System.out::println);
    }
}
