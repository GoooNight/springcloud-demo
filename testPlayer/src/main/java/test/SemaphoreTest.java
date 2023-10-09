package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 * @author 雨天留恋
 * @date 2023-07-11 21:22
 * 令牌使用，只有拿到令牌的才能继续执行
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "拿到了令牌，执行中..." + new SimpleDateFormat("yyyy" +
                            "-MM-dd hh:mm:ss").format(new Date()));
                    Thread.sleep(1000);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Thread" + i).start();
        }
    }
}
