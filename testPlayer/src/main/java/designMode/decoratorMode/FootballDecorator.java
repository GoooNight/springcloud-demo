package designMode.decoratorMode;

/**
 * @author 雨天留恋
 * @date 2023-06-14 19:48
 */
public class FootballDecorator extends HumanDecorator{
    public FootballDecorator(Human human) {
        super(human);
    }

    @Override
    public void say() {
        human.say();
        playFootball();
    }

    @Override
    public int calculate(int a, int b) {
        return human.calculate(a, b);
    }

    private void playFootball() {
        System.out.println("我会踢足球");
    }


}
