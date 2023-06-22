package test;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author 雨天留恋
 * @date 2023-05-31 10:51
 * 文件夹解压
 */
public class UnzipTest {


    public static void unzip(String filePath, String targetPath) {
        File file = new File(filePath);
        try (ZipInputStream inputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            ZipEntry nextEntry;
            while ((nextEntry = inputStream.getNextEntry()) != null) {
                System.out.println(nextEntry.getName());
                if (nextEntry.isDirectory()) {
                    String name = nextEntry.getName();
                    File file1 = new File(targetPath + name + "/");
                    file1.mkdir();
                } else {

                    BufferedOutputStream outputStream =
                            new BufferedOutputStream(new FileOutputStream(targetPath + nextEntry.getName()));
                    byte[] bytes = new byte[1024];
                    int num;
                    while ((num = inputStream.read(bytes, 0, bytes.length)) > 0) {
                        outputStream.write(bytes, 0, num);
                    }
                    outputStream.close();
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        unzip("C:\\Users\\雨天留恋\\Desktop\\zipTest\\test.zip","C:\\Users\\雨天留恋\\Desktop\\zipTest\\");
    }
}
