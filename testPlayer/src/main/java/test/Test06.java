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
public class Test06 extends Student {

    public static void main(String[] args) {



    }
}

@Data
@Builder
@EqualsAndHashCode(of = {"name"})
@NoArgsConstructor
@AllArgsConstructor
class Student{

    int number = 1;
    String name;

}
