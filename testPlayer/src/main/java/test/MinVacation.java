package test;

import java.util.Scanner;

/**
 * @author 雨天留恋
 * @date 2023-05-23 13:39
 * 由于业绩优秀，公司给小Q放了 n 天的假，身为工作狂的小Q打算在在假期中工作、锻炼或者休息。他有个奇怪的习惯：不会连续两天工作或锻炼。只有当公司营业时，小Q才能去工作，只有当健身房营业时，小Q才能去健身，小Q一天只能干一件事。给出假期中公司，健身房的营业情况，求小Q最少需要休息几天。
 * 输入：第一行一个整数 n(1<=n<=100000)表示放假天数 第二行 n 个数 每个数为0或1,第 i 个数表示公司在第 i 天是否营业 第三行 n 个数 每个数为0或1,第 i 个数表示健身房在第 i 天是否营业 （1为营业 0为不营业）
 * 输出：一个整数，表示小Q休息的最少天数
 * 样例输入：4
 * 1 1 0 0
 * 0 1 1 0
 * 样例输出：2
 */
public class MinVacation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node.min = n;
        sc.nextLine();
        String workDaysLine = sc.nextLine();
        String[] workDays = workDaysLine.split("\\s+");
        String exerDaysLine = sc.nextLine();
        String[] exerDays = exerDaysLine.split("\\s+");
        Node.creatTree(0, 0, 0, false, 0, 4, false, workDays, exerDays);
        System.out.println(Node.min);
    }

    private static class Node {
        public int relaxDays;
        public int isWork;
        public int isExer;
        public boolean isError = false;
        public Node left;
        public Node right;
        public static int min;

        public Node(int relaxDays, int isWork, int isExer, Node left, Node right) {
            this.relaxDays = relaxDays;
            this.isWork = isWork;
            this.isExer = isExer;
            this.left = left;
            this.right = right;
        }

        public static Node creatTree(int relaxDays, int isWork, int isExer, boolean isError, int index,
                              int allIndex, boolean isLeft, String[] workDays, String[] exerDays){
            if (index > allIndex) {
                if (!isError){
                    min = Math.min(relaxDays,min);
                }
                return  null;
            }
            Node node = new Node(relaxDays,isWork,isExer,null,null);
            if (isError){
                node.isError = true;

            }
            if (index != 0 && isLeft && !isError){
                if (Integer.parseInt(workDays[index-1])==0) {
                    node.isWork = 0;
                    node.isExer = 0;
                    node.relaxDays ++;
                }else{
                    if(isWork == 1) {
                        node.isError = true;
                    }
                    node.isExer = 0;
                    node.isWork = 1;
                }
            }
            if (index != 0 && !isLeft && !isError) {
                if (Integer.parseInt(exerDays[index - 1]) == 0) {
                    node.isWork = 0;
                    node.isExer = 0;
                    node.relaxDays++;
                }else{
                    if(isExer == 1) {
                        node.isError = true;
                    }
                    node.isWork = 0;
                    node.isExer = 1;
                }
            }

            node.left = creatTree(node.relaxDays, node.isWork, node.isExer, node.isError, index + 1, allIndex, true,
                    workDays, exerDays);
            node.right = creatTree(node.relaxDays, node.isWork, node.isExer, node.isError, index + 1, allIndex, false
                    ,workDays, exerDays);
            return node;
        }
    }

}
