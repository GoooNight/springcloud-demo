package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author 雨天留恋
 * @date 2023-05-23 18:56
 */
public class Test03 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://mirror.aarnet.edu.au/pub/TED-talks/911Mothers_2010W-480p.mp4");
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            File file = new File("C:\\Users\\雨天留恋\\Desktop\\test\\test.mp4");
            FileOutputStream outputStream = new FileOutputStream(file);
            byte[] bytes = new byte[2048];
            int i = 0;
            while ((i = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, i);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
