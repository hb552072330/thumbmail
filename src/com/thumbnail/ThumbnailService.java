package com.thumbnail;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;


@Service
public class ThumbnailService {

	public static final int HEIGHT = 100;
	
	public static final int WIDTH = 100;
	
	public String thumnail(CommonsMultipartFile file, String uploadPath, String realPath)throws Exception{
		String des = realPath + "thum_" + file.getOriginalFilename();
		Thumbnails.of(file.getInputStream()).size(WIDTH, HEIGHT).toFile(des);
		return uploadPath + "/thum_" + file.getOriginalFilename();
	}
}
