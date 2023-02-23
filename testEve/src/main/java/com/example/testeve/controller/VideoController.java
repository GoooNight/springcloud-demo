package com.example.testeve.controller;

import lombok.Cleanup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Optional;

/**
 * @author 雨天留恋
 * @date 2023-02-23 10:48
 * 视频分段播放
 */
@RestController
public class VideoController {

    @GetMapping("play")
    public void getVideoRecourses(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        response.setHeader("Content-Range", "bytes "+rangePre+"-"+(rangePre+len-1)+"/"+fileLength);
        // 将这1MB的视频流响应给客户端
        outputStream.write(bytes,0,len);
        outputStream.close();
        randomAccessFile.close();
        System.out.println("返回数据区间:【"+rangePre+"-"+(rangePre+len)+"】");
    }

}

