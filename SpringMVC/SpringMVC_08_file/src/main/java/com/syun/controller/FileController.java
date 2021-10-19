package com.syun.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@RestController
public class FileController {
	
	// @RequestParam("file")獲取前端上傳的檔案
	@RequestMapping("/upload")
	public String fileUpload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request)throws IOException {
		
		// 獲取上傳檔案名稱
		String uploadFileName = file.getOriginalFilename();
		
		// 檔案名為空返回首頁
		if(uploadFileName.equals("")) {
			return "redirect:/index.jsp";
		}
		
		System.out.println("上傳的檔案名稱:" + uploadFileName);
		
		// 上傳檔案要保存的位置
		String path = request.getServletContext().getRealPath("/upload");
		
		// 如果路徑不存在，則建立一個
		File realPath = new File(path);
		if(!realPath.exists()) {
			realPath.mkdir();
		}
		
		System.out.println("上傳檔案保存位置" + realPath);
		
		InputStream is = file.getInputStream();
		OutputStream os = new FileOutputStream(new File(realPath, "avater.jpg"));
		
		int len = 0;
		byte[] buffer = new byte[1024];
		while((len=is.read(buffer))>0) {
			os.write(buffer,0,len);
			os.flush();
		}
		os.close();
		is.close();
		
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/upload2")
	public String fileUpload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request)throws IOException {
		
		// 上傳檔案要保存的位置
		String path = request.getServletContext().getRealPath("/upload");
		
		// 如果路徑不存在，則建立一個
		File realPath = new File(path);
		if(!realPath.exists()) {
			realPath.mkdir();
		}
		
		System.out.println("上傳檔案保存位置" + realPath);
		
		file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));
		
		return "redirect:/index.jsp";
	}
}
