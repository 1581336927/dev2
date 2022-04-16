package com.hcy.service;

import com.hcy.vo.ResultVo;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    ResultVo upload(MultipartFile file, String type);
}
