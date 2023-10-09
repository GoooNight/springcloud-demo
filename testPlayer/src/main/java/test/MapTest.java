package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 雨天留恋
 * @date 2023-06-06 15:22
 */
public class MapTest {

    public static void mapTest() {
        HashMap<String, Integer> map = new HashMap<>(16);
        Stream<String> original = Stream.of("10", "12", "18");
        Stream<Integer> result = original.map(Integer::parseInt);

    }
}
