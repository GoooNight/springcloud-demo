package reactorDemo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 雨天留恋
 * 发布和订阅
 */
public class ReactorDemo {
    public static void main(String[] args) {
        // 1.方式1
        Flux.just(1,2,3,4,5,6,7,8,9,10).subscribe(System.out::println);
        // 2.方式2
        Flux.just("hello world").subscribe(System.out::println);
        // 3.方式3
        Flux.fromStream(Stream.of(1,2,3,4,5,6,7,8)).subscribe(System.out::println);
        // 3.方式4
        Flux.generate(()->0,(i, sink)->{
            sink.next(i * 2);
            if (i == 10) {
                sink.complete();
            }
            return i+1;
        }).subscribe(System.out::println);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(6);
        list.add(7);
        Mono.just(list).map(integers -> integers.stream().filter(integer -> integer > 5).collect(Collectors.toSet())).subscribe(System.out::println);
    }
}
