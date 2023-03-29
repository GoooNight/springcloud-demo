package com.example.testeve.controller;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


/**
 * @author 雨天留恋
 * @date 2023-02-23 10:48
 * 视频分段播放
 */
@RestController
@Slf4j
public class VideoController {

    /**
     * @param files:
     * @param request:
     * @param response:
     * @return void
     * @author 雨天留恋
     * @description 视频分段播放
     * @date 2023/3/15 16:01
     */
    @GetMapping("play/{file}")
    public void getVideoRecourses(@PathVariable("file") String files, HttpServletRequest request,
                                  HttpServletResponse response) throws IOException {
        System.out.println(files);
        // 重置response
        response.reset();
        File file = new File("E:\\电影\\宠女青春白皮书\\[MagicStar] Oyabaka Seishun Hakusho EP03 [WEBDL] [1080p].mkv");
        long fileLength = file.length();
        // 随机读取文件
        @Cleanup RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");

        // 获取视频所需范围
        String range = request.getHeader("Range");
        System.out.println(range);
        if (range == null || range.isEmpty() || range.isBlank()) {
            range = "Range=0-1048576";
        }

        long rangePre = 0;
        if (!range.isBlank()) {
            rangePre = Long.parseLong(range.substring(range.indexOf("=") + 1, range.indexOf("-")));
        }
        // 获取相应数据流
        @Cleanup ServletOutputStream outputStream = response.getOutputStream();
        response.setHeader("Content-Type", "video/mp4");
        response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);

        // 移动访问指针到指定位置
        randomAccessFile.seek(rangePre);
        // 数据数组
        byte[] bytes = new byte[1024 * 1024];
        int len = randomAccessFile.read(bytes);

        response.setContentLength(len);
        //设置此次相应返回的数据范围(rangePre+len-1是因为浏览器开始指针会+1)
        response.setHeader("Content-Range", "bytes " + rangePre + "-" + (rangePre + len - 1) + "/" + fileLength);
        // 将这1MB的视频流响应给客户端
        outputStream.write(bytes, 0, len);
        outputStream.close();
        randomAccessFile.close();
        System.out.println("返回数据区间:【" + rangePre + "-" + (rangePre + len) + "】");
    }
    /**
     * @param response:
     * @param request:
     * @return void
     * @author 雨天留恋
     * @description 视频直接播放，无法点击
     * @date 2023/3/15 16:23
     */
    @GetMapping("playVideo")
    public void playVideo(HttpServletResponse response, HttpServletRequest request) throws Exception {
        URL url = new URL("http://stream4.iqilu.com/ksd/video/2020/02/17/97e3c56e283a10546f22204963086f65.mp4");
        URLConnection connection = url.openConnection();
        int contentLength = connection.getContentLength();
        @Cleanup InputStream inputStream = connection.getInputStream();
        byte[] bytes = new byte[1024*1024];
        @Cleanup ServletOutputStream outputStream = response.getOutputStream();
        int len = 0;
        int count = 0;
        response.setContentType("video/mp4");
        // 必须获取文件长度
        response.setContentLength(contentLength);
        // 设置缓冲区大小，默认1024*8，每次缓冲区满就会发送给客户端
        response.setBufferSize(1024*1024*8);
        while ((len = inputStream.read(bytes)) != -1) {
            count += len;
            // 如果没有方法flushBuffer()，则需要等缓冲区满了才会把数据发送给客户端
            outputStream.write(bytes, 0, len);
            System.out.println(response.isCommitted());
            System.out.println(len);
            // flushBuffer()方法会把缓冲区的数据发送给客户端
            response.flushBuffer();
        }

    }

}

