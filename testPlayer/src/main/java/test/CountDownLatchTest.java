package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.CountDownLatch;

/**
 * @author 雨天留恋
 * @date 2023-05-23 18:56
 * 测试CountDownLatch，当一个线程调用countDownLatch.await()时，只有countDownLatch.countDown()减少到0时才能继续
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Thread thread1 = new Thread(() -> {
            System.out.println(1);
                countDownLatch.countDown();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1_1");

        });
        Thread thread2 = new Thread(() -> {
            System.out.println(2);
                countDownLatch.countDown();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("2_1");

        });
        Thread thread3 = new Thread(() -> {
            System.out.println(3);
                countDownLatch.countDown();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("3_1");
        });
        Thread thread4 = new Thread(() -> {
            System.out.println(4);
            try {
                countDownLatch.await();
                System.out.println("4_1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}
