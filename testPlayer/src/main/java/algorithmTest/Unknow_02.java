package algorithmTest;

import java.util.List;

/**
 * @author 雨天留恋
 * @date 2022-12-12 21:00
 * 任务一:随机生成字符串，字符串由n(0<=n<1000)个字符组成，字符限定为'a''b''c'd''e'，使用队列统计字符连续的子串(字符连续出现5次)，并给
 * 出该子串的起始位置和子串值，例如，字符串“abcaaaaaaadae”包括3个连续
 * 订 的子串“aaaaa”。
 * 任务二:输入一批水果，包括水果名和价格，请按水果价格排序并输出水
 * 果信息，请使用冒泡，直接插入排序，选择排序，折半插入排序方法实现(至
 * 少实现2种方法)。
 *
 * 任务三:现有学生成绩清单，成绩清单列表项包括学生姓名、课程名称、
 * 课程成绩，请用有序二叉树存储结构管理学生成绩清单，用树结点表示学生。
 * 按成绩大小将学生有序插入该二叉树，用中序遍历方法按成绩查找方式显示学
 * 生信息。
 *
 * 任务四:自行设计和实现栈相关应用。
 * 线
 */
public class Unknow_02 {

    public static void findSubStringOfFiveLength(String s) {
        // 使用滑动窗口算法
        int legalLength = 4;
        int left = 1;
        int right= 0;
        while (left < s.length()) {
            if (s.charAt(left) != s.charAt(left - 1)) {
                right = left;
            }else if (left - right == legalLength) {
                System.out.println(s.substring(right, left+1));
                right+=1;
            }
            left ++;
        }
    }

    public static void main(String[] args) {
        findSubStringOfFiveLength("abssssssabbbbbas");
    }
}
