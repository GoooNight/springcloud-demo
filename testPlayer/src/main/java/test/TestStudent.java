package test;

import lombok.*;

import java.util.Objects;

/**
 * @author 雨天留恋
 * @date 2023-07-10 16:25
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class TestStudent {

    private String name;

    private String uuid;

    private String classTeacher;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestStudent that = (TestStudent) o;
        return Objects.equals(name, that.name) && Objects.equals(classTeacher, that.classTeacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, classTeacher);
    }
}
