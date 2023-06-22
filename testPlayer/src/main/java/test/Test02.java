package test;

import java.util.concurrent.*;

/**
 * @author 雨天留恋
 * @date 2023-05-23 13:39
 */
public class Test02 {

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        FutureTask<Integer> task = new FutureTask<>(() -> 0);
        System.out.println("----main线程开始-----");
        poolExecutor.execute(task);
        try {
            Integer integer = task.get();
            System.out.println("task线程"+integer);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("--------main线程结束-------");
        poolExecutor.shutdown();
    }

}
