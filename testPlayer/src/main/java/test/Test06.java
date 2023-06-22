package test;

import lombok.*;
import test.defaultTest.DefaultTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author 雨天留恋
 * @date 2023-06-15 10:04
 */
public class Test06 {



    public static void main(String[] args) {

        try {
            Class<?> aClass = Class.forName("test.BeanReflectTest");
            Constructor<?> constructor = aClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            BeanReflectTest test = (BeanReflectTest) constructor.newInstance();
            Field field = aClass.getDeclaredField("name");
            field.setAccessible(true);
            field.set(test,"123");
            System.out.println(test);

            System.out.println(BeanReflectTest.getBeanReflectTest());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

@Data
@Builder
@EqualsAndHashCode(of = {"name"})
class Student{

    private Student(String number, String name) {
        this.number = number;
        this.name = name;
    }
    String number;
    String name;

}
