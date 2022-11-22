package assertDemo;


/**
 * @author 雨天留恋
 */
public class AssertDemo {


    public void test() {
        boolean flag = false;
        assert flag;
        System.out.println("1");
    }

    public static void main(String[] args) {
        
        new AssertDemo().test();
    }
}
