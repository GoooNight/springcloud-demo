package test;

import java.util.List;

/**
 * @author 雨天留恋
 * @date 2023-07-31 10:43
 */
public class Test05 {
    public static void main(String[] args) {
        String s = "河北省,山西省,辽宁省,吉林省,黑龙江省,江苏省,浙江省,安徽省,福建省,江西省,山东省,河南省,湖北省," +
                "湖南省,广东省,海南省," +
                "四川省,贵州省,云南省,陕西省,甘肃省,青海省,台湾省";


        List<String> provinceList = List.of(s.split(","));
        provinceList.forEach(System.out::println);
    }
}
