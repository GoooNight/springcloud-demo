package test;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

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



    public static void main(String[] args) {
        Test04 t3 = new Test04();
    }
}
