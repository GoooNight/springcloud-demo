package algorithmTest;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author 雨天留恋
 */
public class Unknow {
    public static int unknow01(int n) {
        int result = n;
        int prev = n;
        for (int i = 1; i < n; i++) {
            int cur = prev * 10 + n;
            result += cur;
            prev = cur;
        }
        return result;
    }

    public static List<User> getAgeCategories(int n) {
        List<User> result = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            int age = sc.nextInt();
            if (0 < age && age < 150) {
                User user = User.builder().age(age).build();
                if (user.getAge() < 30) {
                    result.add(user);
                } else {
                    result.add(user);
                }
            } else {
                System.out.println("请输入正确的年龄！");
                i--;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Map<Boolean, List<User>> collect = getAgeCategories(10).stream().collect(Collectors.groupingBy((user) -> user.getAge() < 30));

    }
}

@Data
@Builder(toBuilder = true)
class User {
    private Integer age;
}