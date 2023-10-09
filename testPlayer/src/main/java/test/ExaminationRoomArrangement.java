package test;


import java.sql.ResultSet;
import java.util.*;
/**
 * @author 雨天留恋
 * @date 2023-08-03 10:59
 */
public class ExaminationRoomArrangement {

    public static void main(String[] args) {
        int a1 = 0;
        Set<Integer> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] result = new int[num+1][num+1];
        int friendPair = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < friendPair; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            sc.nextLine();
            result[x-1][y-num-1]=1;
        }
        calLine(result,num);
        calRow(result,num);
        int maxLine = getMaxLine(result, num);
        int maxRow = getMaxRow(result, num);
        a1 = getA1(a1, set, num, result, maxLine, maxRow);
        System.out.println(a1);
        set.stream().sorted().forEach(key->System.out.print(key+" "));
    }

    private static int getA1(int a1, Set<Integer> set, int num, int[][] result, int maxLine, int maxRow) {
        while ( result[maxLine][num]!= 0 || result[num][maxRow] != 0) {
            a1++ ;
            if (result[maxLine][num] < result[num][maxRow]) {
                for (int i = 0; i < num; i++) {
                    result[i][maxRow] = 0;
                }
                set.add(maxRow + num +1);
            }else if(result[maxLine][num] == result[num][maxRow]){
                HashSet<Integer> set1 = new HashSet<>();
                int[][] res1 = result;
                for (int i = 0; i < num; i++) {
                    res1[i][maxRow] = 0;
                }
                calLine(res1, num);
                calRow(res1, num);
                maxLine = getMaxLine(res1, num);
                maxRow = getMaxRow(res1, num);
                int a11 = getA1(a1, set1, num, res1, maxLine, maxRow);
                HashSet<Integer> set2 = new HashSet<>();
                int[][] res2 = result;
                for (int i = 0; i < num; i++) {
                    res2[i][maxRow] = 0;
                }
                calLine(res2, num);
                calRow(res2, num);
                maxLine = getMaxLine(res2, num);
                maxRow = getMaxRow(res2, num);
                int a12 = getA1(a1, set2, num, res2, maxLine, maxRow);
                if (a11 > a12) {
                    set.addAll(set1);
                    result = res1;
                }else {
                    set.addAll(set2);
                    result = res2;
                }
            }
            else {

                for (int i = 0; i < num; i++) {
                    result[maxLine][i] = 0;
                }
                set.add(maxLine +1);
            }
            calLine(result, num);
            calRow(result, num);
            maxLine = getMaxLine(result, num);
            maxRow = getMaxRow(result, num);
        }
        return a1;
    }

    public static void calLine(int[][] result, int num){
        for (int i = 0; i < num; i++) {
            result[i][num] = 0;
            for (int j = 0; j < num; j++) {
                result[i][num] += result[i][j];
            }
        }
    }
    public static void calRow(int[][] result, int num){
        for (int i = 0; i < num; i++) {
            result[num][i] = 0;
            for (int j = 0; j < num; j++) {
                result[num][i] += result[j][i];
            }
        }
    }

    public static Integer getMaxLine(int[][] result, int num){
        int max = 0;
        int maxLine = 0;
        for (int i = 0; i < num; i++) {
            if (result[i][num] > max){
                max = result[i][num];
                maxLine = i;
            }
        }
        return maxLine;
    }
    public static Integer getMaxRow(int[][] result, int num){
        int max = 0;
        int maxRow = 0;
        for (int i = 0; i < num; i++) {
            if (result[num][i] > max){
                max = result[num][i];
                maxRow = i;
            }
        }
        return maxRow;
    }

}
