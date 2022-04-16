package com.hcy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("file")
public class FileUploadController {
    @RequestMapping("upload")
    public ModelAndView upload(MultipartFile upload) {
        // 准备一个存放图片的路径
        String path = "D:/image";

        // 创建File对象
        File file = new File(path);

        // 如果当前路径为空
        if (!file.exists()) {

            // 创建该文件夹的多级目录
            file.mkdirs();
        }

        // 说明上传文件项
        // 获取上传文件的名称
        String filename = upload.getOriginalFilename();

        try {
            // 如果文件名称不为空id
            if (filename != null) {
                // 完成文件上传
                upload.transferTo(new File(path, filename));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();

        // 将图片的路径Model中
        modelAndView.addObject("img", "http://localhost:88/upload/" + filename);

        // 设置要跳转的路径
        modelAndView.setViewName("/success.jsp");

        return modelAndView;
    }
}