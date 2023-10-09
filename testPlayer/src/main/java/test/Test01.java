package test;

import java.util.*;

/**
 * @author 雨天留恋
 * @date 2023-05-18 16:27
 */
public class Test01 {


    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>(Comparator.comparing(s -> s.charAt(0)));
        Scanner scanner = new Scanner(System.in);
        int nums = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < nums; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            int lineNum = Integer.parseInt(line[0]);
            if (line.length > lineNum + 1) {
                return;
            }
            for (int j = 1; j < line.length; j++) {
                if (line[j].length()>20){
                    return;
                }
                map.merge(line[j],4-j, Integer::sum);
            }
        }
        map.forEach((s, integer) -> System.out.println(s+" "+integer));

    }
}
