package test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author 雨天留恋
 * @date 2023-06-05 10:39
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() ->
                "hello!");
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> System.out.println("hello"));
        System.out.println(future1.get());

    }

}
