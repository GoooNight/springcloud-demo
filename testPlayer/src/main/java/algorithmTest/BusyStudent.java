package algorithmTest;

/**
 * @author 雨天留恋
 *  1450. 在既定时间做作业的学生人数
 */
public class BusyStudent {
    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int result = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
