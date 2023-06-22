package test;

/**
 * @author 雨天留恋
 * @date 2023-05-11 15:50
 */
public class HasStatic {
    private static int x = 100;

    public static void main(String[] args) {
        HasStatic hs1 = new HasStatic();
        hs1.x++;
        HasStatic hs2 = new HasStatic();
        hs2.x++;
        hs1 = new HasStatic();
        hs1.x++;
        HasStatic.x--;
        System.out.println("x=" + x);

    }
}
