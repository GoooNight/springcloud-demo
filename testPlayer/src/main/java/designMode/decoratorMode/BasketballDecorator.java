package designMode.decoratorMode;

/**
 * @author 雨天留恋
 * @date 2023-06-14 19:46
 */
public class BasketballDecorator extends HumanDecorator{
    public BasketballDecorator(Human human) {
        super(human);
    }

    @Override
    public void say() {
        human.say();
        playBasketball();
    }

    @Override
    public int calculate(int a, int b) {
        return human.calculate(a, b);
    }

    private void playBasketball() {
        System.out.println("我会玩篮球");
    }

}
