package designMode.decoratorMode;

/**
 * @author 雨天留恋
 * @date 2023-06-14 19:41
 */
public class XiaoHong implements Human{
    @Override
    public void say() {
        System.out.println("我是小红！");
    }

    @Override
    public int calculate(int a, int b) {
        System.out.println("我会计算加法");
        return a + b;
    }
}
