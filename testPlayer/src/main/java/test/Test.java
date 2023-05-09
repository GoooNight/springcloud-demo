package test;

/**
 * @author 雨天留恋
 * @date 2023-03-10 20:38
 */
@FunctionalInterface
public interface Test {

    void get();

    default void set() {
        System.out.println("333");
    }

}
