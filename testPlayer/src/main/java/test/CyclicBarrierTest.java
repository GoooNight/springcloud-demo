package test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 雨天留恋
 * @date 2023-07-12 15:01
 */
public class CyclicBarrierTest {


    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> System.out.println("大家都到了啊"));

        for (int i = 0; i < 3; i++) {
            pool.execute(()-> {
                System.out.println(Thread.currentThread().getName()+"线程等待大家都到");
                try {
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName()+"线程发现大家都到了，开始游戏，等待大家准备");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName()+"开始游戏");

                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }


            });

        }

    }
}
