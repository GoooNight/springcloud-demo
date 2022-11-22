package nioCopy;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
 * @author 雨天留恋
 * Nio copy
 */
public class NioCopy {

    public void copy() {
        File file = new File("C:\\Users\\雨天留恋\\Desktop\\test\\123.PNG");
        File file1 = new File("C:\\Users\\雨天留恋\\Desktop\\test\\223.PNG");
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        FileChannel inputStreamChannel = null;
        FileChannel outputStreamChannel = null;
        try {
            inputStream = new FileInputStream(file);
            outputStream = new FileOutputStream(file1);
            inputStreamChannel = inputStream.getChannel();
            outputStreamChannel = outputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int len = 0;
            /**
             * 方法一
             */
//            inputStreamChannel.transferTo(0, inputStreamChannel.size(), outputStreamChannel);
            /**
             * 方法二
             */
            while ((len = inputStreamChannel.read(byteBuffer)) != -1) {
                byteBuffer.flip();
                outputStreamChannel.write(byteBuffer);
                byteBuffer.clear();
            }


        } catch (FileNotFoundException e) {
            System.out.println("文件未找到！");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                assert outputStreamChannel != null;
                outputStreamChannel.close();
                inputStreamChannel.close();
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new NioCopy().copy();
    }

}
