package test;

import java.io.*;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author 雨天留恋
 * @date 2023-05-30 14:05
 * 文件夹压缩
 */
public class ZipTest {


    public static void zip(File file, ZipOutputStream outputStream, String filePath) throws IOException {
        if (file.isDirectory()) {
            // 如果是文件夹，则只创建实体即可
            ZipEntry entry = new ZipEntry(filePath + file.getName() + "/");
                outputStream.putNextEntry(entry);
            for (File listFile : Objects.requireNonNull(file.listFiles())) {
                zip(listFile, outputStream,filePath + file.getName() + "/");
            }
        } else {
            ZipEntry entry = new ZipEntry(filePath + file.getName());
            outputStream.putNextEntry(entry);
            byte[] bytes = new byte[4 * 1024];
            int len = 0;
            try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
                while ((len = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\雨天留恋\\Desktop\\zipTest\\test");
        String outputPath = "C:\\Users\\雨天留恋\\Desktop\\zipTest\\test.zip";
        try (ZipOutputStream zipOutputStream =
                     new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outputPath)))) {

            zip(file, zipOutputStream, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
