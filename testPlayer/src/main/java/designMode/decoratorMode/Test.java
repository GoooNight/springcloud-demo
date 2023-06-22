package designMode.decoratorMode;

/**
 * @author 雨天留恋
 * @date 2023-06-14 19:49
 */
public class Test {
    public static void main(String[] args) {
        XiaoHong xiaoHong = new XiaoHong();
        XiaoMing xiaoMing = new XiaoMing();

        BasketballDecorator basketballDecorator = new BasketballDecorator(xiaoMing);
        basketballDecorator.say();

        FootballDecorator footballDecorator = new FootballDecorator(xiaoHong);
        footballDecorator.say();


    }
}
