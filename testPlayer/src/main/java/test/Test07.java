package test;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 * @author 雨天留恋
 * @date 2023-08-01 20:52
 */
@Setter
public class Test07 <T,V,F>{

    T s;
    V v;
    F f;

    public static void main(String[] args) {
        User user = new User();
        user.setAge(18);
        user.setName("XiaoMing");
        Test07<User, Integer, Integer> test07 = new Test07<>();
        test07.setS(user);
        test07.setV(user.getAge());
        test07.setF(user.getAge());
        test07.test(User::addAge);
    }

    public void test(InterfaceTest<T,V,F> test){
        System.out.println(test.consume(s,f));
    }

}

@FunctionalInterface
interface InterfaceTest<T,V,F>{

    V consume(T t,F f);

}

@Getter
@Setter
class  User{
    private String name;
    private int age;

    public int addAge(int age){
     return age/2 + 1;
    }
}