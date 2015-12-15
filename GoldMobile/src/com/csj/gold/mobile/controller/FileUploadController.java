package com.csj.gold.mobile.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.csj.gold.utils.file.FileUtil;
@Controller
@RequestMapping("/file")
public class FileUploadController {
	
	@RequestMapping("upload")  
    public void upload(@RequestParam("imageFile") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {  
        FileUtil.uploadFile(file, request);  
    }  
  
//    @RequestMapping("download")  
//    public void download(String fileName, HttpServletResponse response) throws IOException {  
//        OutputStream os = response.getOutputStream();  
//        try {  
//            response.reset();  
//            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);  
//            response.setContentType("image/jpeg; charset=utf-8");  
//            os.write(FileUtils.readFileToByteArray(FileUtil.getFile(fileName)));  
//            os.flush();  
//        } finally {  
//            if (os != null) {  
//                os.close();  
//            }  
//        }  
//    }  
}