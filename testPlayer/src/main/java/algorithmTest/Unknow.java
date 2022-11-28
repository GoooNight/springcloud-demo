package algorithmTest;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 雨天留恋
 */
public class Unknow extends Object {
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


    public static void getStudents(int n) {
        Student[] stus = new Student[n];
        Student student = new Student(17,18,"name");
        stus[0] = student;
        for (Student stu1 : stus) {
            System.out.println(stu1);
        }
    }

    public static void main(String[] args) {
        getStudents(1);

    }
}

@Data
@Builder()
class User {
    private Integer age;
}

@Data
@Builder()
class Student {
    private Integer age;
    private Integer height;
    private String name;
}