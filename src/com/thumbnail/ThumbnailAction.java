package com.thumbnail;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ThumbnailAction {
	
	@Autowired
	private UploadService uploadService;
	
	@Autowired
	private ThumbnailService thumbnailService;
	
	
	@RequestMapping(value="/thumbnail", method=RequestMethod.POST)
	public ModelAndView thumbnail(@RequestParam("image") CommonsMultipartFile commonsMultipartFile, HttpSession httpSession) throws Exception{
		String uploadPath = "/images";
		String realPath = httpSession.getServletContext().getRealPath(uploadPath);
		
		String imageUrl = uploadService.uploadImage(commonsMultipartFile, uploadPath, realPath);
		String thumImageUrl = thumbnailService.thumnail(commonsMultipartFile, uploadPath, realPath);
		//return new ModelAndView("redirect:/thumbnails.jsp");
		ModelAndView res = new ModelAndView();
		res.addObject("imageUrl",imageUrl);
		res.addObject("thumImageUrl", thumImageUrl);
		
		res.setViewName("thumbnails");
		return res;
	}
}
