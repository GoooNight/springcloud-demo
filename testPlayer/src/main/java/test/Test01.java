package test;

/**
 * @author 雨天留恋
 * @date 2023-05-18 16:27
 */
public class Test01 {


    public static int f(int day) {
        if (day == 10) {
            return 1;
        } else {
            return (f(day + 1) + 1) * 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(f(9));
    }

}
