package com.csj.gold.utils.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.csj.gold.utils.StaticValues;
import com.csj.gold.utils.SystemPropertiesUtils;

public class FileUtil {
	  
    //文件上传  
    public static String uploadFile(MultipartFile file) throws IOException {  
        String fileName = file.getOriginalFilename();  //上传时的名称
        File tempFile = new File(SystemPropertiesUtils.getSystemProperties(StaticValues.WEB_APPLICATION_HOME)+SystemPropertiesUtils.getSystemProperties(StaticValues.SAVE_IMAGE_FILE_PATH), new Date().getTime() + String.valueOf(fileName));  
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
        return new File(SystemPropertiesUtils.getSystemProperties(StaticValues.SAVE_IMAGE_FILE_PATH), fileName);  
    }  
}
