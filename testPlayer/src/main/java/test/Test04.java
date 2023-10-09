package test;

import cn.hutool.extra.spring.SpringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 雨天留恋
 * @date 2023-05-29 10:26
 */
public class Test04 {
    static{
        System.out.println("静态代码块");
    }
    public static Test04 t1 = new Test04();
    public static Test04 t2 = new Test04();

    {
        System.out.println("代码块");
    }

    public void throwExceptionTest() throws Exception{

    }


    public static void main(String[] args) {
        Test04 t3 = new Test04();
        String s = Integer.toString(11);
        String t = "11";
        String v = s.intern();

        System.out.println(v == t);
        Integer[] i = {1, 2, 3};
        List<Integer> list = Arrays.asList(i);
        i[0]= 2;
        System.out.println(list);
        int a[][] = new int[6][];
        List<String> list1 = new ArrayList<>(8);
        list1.add("zz");
        list1.add("zs");
        list1.add("zw");
        list1.add("zz");
        System.out.println("======分界线======");


    }
}
