package test;

import java.util.*;
import java.util.stream.Collectors;

public class Main {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<Integer,Integer> map = new HashMap<>(n);
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
            map.put(i,0);
        }
        List<Integer> collect =
                list.stream().sorted(Comparator.comparing(Integer::intValue)).collect(Collectors.toList());

        // 普通攻击次数
        int result = 0;
        // 普攻指针
        int pIndex = 0;
        // 转圈圈的次数
        int zhuan = 0;
        // 指针，用来判断是否可以发送转圈圈
        int zhuanIndex = 0;
        while (zhuanIndex < collect.size()) {
            // 判断是否可以转圈圈
            if ((collect.get(zhuanIndex)-zhuan-map.get(zhuanIndex)) <= collect.get(zhuanIndex)/2) {
                pIndex++;
                zhuan ++;
                zhuanIndex ++;
            }else {
                result++;
                map.merge(pIndex,1, Integer::sum);
            }
        }
        for (int i = 0; i < collect.size(); i++) {
            if ((collect.get(i)-zhuan-map.get(i))>0){
                result += (collect.get(i)-zhuan-map.get(i));
            }
        }

        System.out.println(result);


    }



}
