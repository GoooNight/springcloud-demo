package jobs.mihayou;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 雨天留恋
 * @date 2023-08-27 19:56
 */
public class Test01 {


    static class Toy{

        public int preMonth;

        public int lastMonth;

        public boolean isBuy;

        public Toy(int preMonth, int lastMonth) {
            this.preMonth = preMonth;
            this.lastMonth = lastMonth;
            this.isBuy = false;
        }

        @Override
        public String toString() {
            return "Toy{" +
                    "preMonth=" + preMonth +
                    ", lastMonth=" + lastMonth +
                    ", isBuy=" + isBuy +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        // 每个月能够买的
        Map<Integer, List<Toy>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Toy> toys = new ArrayList<>(i);
            Toy toy = new Toy(i, i + in.nextInt());
            toys.add(toy);
            if(i!=0){
                List<Toy> nextToys = map.get(i-1);
                for (Toy nextToy : nextToys) {
                    if (nextToy.lastMonth>=i){
                        toys.add(nextToy);
                    }
                }
            }
            map.put(i,toys);
        }
        in.nextLine();
        for (int i = 0; i < n; i++) {
            int number = in.nextInt();
            List<Toy> toys = map.get(i);
            if (toys == null){
                continue;
            }
            List<Toy> collect =
                    toys.stream()
                            .sorted(Comparator.comparing(o -> ((Toy)o).lastMonth)
                                    .thenComparing(o -> ((Toy)o).preMonth))
                            .collect(Collectors.toList());
            for (int j = 0; j < collect.size() && number > 0; j++) {
                Toy toy = collect.get(j);
                if (!toy.isBuy){
                    System.out.println(toy);
                    toy.isBuy = true;
                    number--;
                }

            }

        }

    }


}
