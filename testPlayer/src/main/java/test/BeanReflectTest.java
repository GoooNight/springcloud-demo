package test;

import lombok.Builder;
import lombok.Data;


/**
 * @author 雨天留恋
 * @date 2023-06-20 21:44
 */
@Data
public class BeanReflectTest {

    private String name;

    private String version;

    private final static BeanReflectTest beanReflectTest = new BeanReflectTest();

    private BeanReflectTest() {
        if (beanReflectTest != null) {
            throw new RuntimeException("不允许反射创建");
        }
    }

    public static BeanReflectTest getBeanReflectTest() {
        return beanReflectTest;
    }
}
