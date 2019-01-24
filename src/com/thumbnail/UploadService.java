package com.thumbnail;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service
public class UploadService {

	public String uploadImage(CommonsMultipartFile commonsMultipartFile, String uploadPath, String realPath)throws Exception{
		if(commonsMultipartFile == null){
			throw new RuntimeException("上传文件不能为空");
		}
		InputStream inputStream = commonsMultipartFile.getInputStream();
		OutputStream outputStream = new FileOutputStream(new File(realPath + "/" + commonsMultipartFile.getOriginalFilename()));
		IOUtils.copy(inputStream, outputStream);
		return uploadPath + "/" + commonsMultipartFile.getOriginalFilename();
	}
}
