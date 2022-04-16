package com.hcy.service.impl;

import com.hcy.service.FileUploadService;
import com.hcy.vo.ResultVo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Override
    public ResultVo upload(MultipartFile file, String type) {

        //准备文件存储的路径
        String path="C:\\Users\\HCY\\Desktop\\JavaMd\\15_Tomcat\\apache-tomcat2-8.5.37\\webapps\\upload\\poverty-Alleviation\\"+type;

        File pathFile = new File(path);

        if (!pathFile.exists()){
            //创建多级路径
            pathFile.mkdirs();
        }

        //获取原始的文件名
        String originalFilename = file.getOriginalFilename();

        //获取时间的格式化器
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        //获取格式化之后的当前日期时间
        String format = formatter.format(new Date());

        //获取文件的后缀名
        String suufix = originalFilename.substring(originalFilename.lastIndexOf("."));

         //新的文件名等于格式化之后的日期时间加上后缀名
        originalFilename = format + suufix;

        HashMap<Object, Object> map = new HashMap<>();
        map.put("imgurl","http://localhost:8081/upload/poverty-Alleviation/"+type+"/"+originalFilename);


        ResultVo resultVo = new ResultVo();
        resultVo.setCode(200);
        resultVo.setMessage("上传成功");
        resultVo.setSuccess(true);
        resultVo.setData(map);

        try {
            //文件上传操作
            file.transferTo(new File(pathFile,originalFilename));
        } catch (IOException e) {
            e.printStackTrace();
            resultVo.setCode(-1);
            resultVo.setMessage("上传失败");
            resultVo.setSuccess(false);
        }


        return resultVo;
    }
}
