package com.csj.gold.utils.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	public static final String PARENT_FLODER_PATH = "E:/Tomcat/7/apache-tomcat-7.0.62/webapps/GoldMobile/upload/"; //父文件目录
	  
    //文件上传  
    public static String uploadFile(MultipartFile file) throws IOException {  
        String fileName = file.getOriginalFilename();  //上传时的名称
        File tempFile = new File(PARENT_FLODER_PATH, new Date().getTime() + String.valueOf(fileName));  
        if (!tempFile.getParentFile().exists()) {  
            tempFile.getParentFile().mkdir();  
        }  
        if (!tempFile.exists()) {  
            tempFile.createNewFile();  
        }  
        file.transferTo(tempFile);  
        return tempFile.getName();  
    }  
  
    public static File getFile(String fileName) {  
        return new File(PARENT_FLODER_PATH, fileName);  
    }  
}
