package com.hcy.controller;

import com.hcy.service.FileUploadService;
import com.hcy.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping("uploadImg")
    public ResultVo upload(MultipartFile file, @RequestParam String type){


    return fileUploadService.upload(file,type);
    }
}
