package designMode.decoratorMode;

/**
 * @author 雨天留恋
 * @date 2023-06-14 19:43
 */
public abstract class HumanDecorator implements Human {
    public Human human;

    public HumanDecorator(Human human) {
        this.human = human;
    }

    @Override
    public void say() {
        human.say();
    }

    @Override
    public int calculate(int a, int b) {
        return human.calculate(a, b);
    }
}
