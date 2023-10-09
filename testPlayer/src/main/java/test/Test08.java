package test;

import java.util.*;

/**
 * @author 雨天留恋
 * @date 2023-08-06 21:08
 */
public class Test08 {

    private static class Xy{

        public Xy(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x;
        public int y;
    }

    public static void main(String[] str) {
        Queue<Xy> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        //
        int[][] bp = new int[n][10];
        int pre = n-2;
        int last = n-1;
        bp[last][numbers[n-1]] = 1;
        queue.add(new Xy(numbers[pre],numbers[last]));
        while (pre > 0) {
            int j = queue.size();
            while (j > 0){
                Xy xy = queue.poll();
                int g1 = (xy.x + xy.y) % 10;
                bp[pre][g1] += bp[last][xy.y];
                int g2 = (xy.x * xy.y) % 10;
                bp[pre][g2] += bp[last][xy.y];
                j--;
            }
            for (int i = 0; i < 10; i++) {
                if (bp[pre][i] > 0){
                    queue.add(new Xy(numbers[pre-1],i));
                }
            }
            pre -= 1;
            last -= 1;
        }
        while (!queue.isEmpty()){
            Xy xy = queue.poll();
            int g1 = (xy.x + xy.y) % 10;
            bp[pre][g1] += bp[last][xy.y];
            int g2 = (xy.x * xy.y) % 10;
            bp[pre][g2] += bp[last][xy.y] ;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(bp[0][i] % (1000000007));
        }

    }
}




