package test;

import cn.hutool.core.util.IdUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 雨天留恋
 * @date 2023-07-10 16:24
 */
@Data
public class RemoveDuplicateData {


    public static void main(String[] args) {
        TestStudent student01 =
                TestStudent.builder().uuid(IdUtil.getSnowflakeNextIdStr()).name("红").classTeacher("李").build();
        TestStudent student02 =
                TestStudent.builder().uuid(IdUtil.getSnowflakeNextIdStr()).name("红").classTeacher("李").build();
        TestStudent student03 =
                TestStudent.builder().uuid(IdUtil.getSnowflakeNextIdStr()).name("黄").classTeacher("陈").build();
        TestStudent student04 =
                TestStudent.builder().uuid(IdUtil.getSnowflakeNextIdStr()).name("蓝").classTeacher("李").build();
        TestStudent student05 =
                TestStudent.builder().uuid(IdUtil.getSnowflakeNextIdStr()).name("绿").classTeacher("陈").build();
        ArrayList<TestStudent> testStudents = new ArrayList<>() {{
            add(student01);
            add(student02);
            add(student03);
            add(student04);
            add(student05);
        }};
        // testStudents.forEach(System.out::println);
        testStudents.stream().distinct().forEach(System.out::println);

    }
}