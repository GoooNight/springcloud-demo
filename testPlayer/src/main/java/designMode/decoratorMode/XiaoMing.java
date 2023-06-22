package designMode.decoratorMode;

/**
 * @author 雨天留恋
 * @date 2023-06-14 19:37
 */
public class XiaoMing implements Human{
    @Override
    public void say() {
        System.out.println("我是小明！");
    }

    @Override
    public int calculate(int a, int b) {
        System.out.println("我会计算乘法");
        return a * b;
    }
}
