package com.thumbnail;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service
public class ThumbnailAWTService {

	public static final int HEIGHT = 100;
	
	public static final int WIDTH = 100;
	
	public String thumbnail(CommonsMultipartFile file , String uploadPath, String realPath)throws Exception{
		
		String des = realPath + "/thum_" + file.getOriginalFilename();
		
		Image image = ImageIO.read(file.getInputStream());
		int height = image.getHeight(null);
		int width = image.getWidth(null);
		
		
		int rate1 = width/WIDTH;
		int rate2 = height/HEIGHT;
		int rate = 0;
		if(rate1 > rate2){
			rate = rate1;
		}else{
			rate = rate2;
		}
		
		int newWidth = width/rate;
		int newHeight = height/rate;
		
		BufferedImage bufferedImage = new BufferedImage(newWidth, height, BufferedImage.TYPE_INT_RGB);
		bufferedImage.getGraphics().drawImage(image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH)
				, 0, 0, null);
		
		String imageType = file.getContentType().substring(file.getContentType().indexOf("/")+1);
		ImageIO.write(bufferedImage, imageType, new FileOutputStream(des));
		
		return uploadPath + "/" + file.getOriginalFilename();
	}
}
