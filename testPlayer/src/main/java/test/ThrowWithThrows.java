package test;


import java.util.Optional;

/**
 * @author 雨天留恋
 * @date 2023-04-24 16:08
 */
public class ThrowWithThrows {

    class User{

    }

    public static void thr() throws NullPointerException {
        User user1 = new ThrowWithThrows().new User();
        User user2 = null;
        User user = Optional.ofNullable(user2).orElseThrow(() -> new RuntimeException("你好"));
        System.out.println(user);
    }

    public static void main(String[] args) throws Exception {
        ThrowWithThrows.thr();
    }
}
