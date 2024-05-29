package com.example.demo.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.FileService;

@Service
public class FileServiceImp implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		//File name
		 String name = file.getOriginalFilename();
		 
		 String randomID = UUID.randomUUID().toString();
		 String fileName1 = randomID.concat(name.substring(name.lastIndexOf(".")));
		 
		//Fullpath
		 String filePath = path+ File.separator+fileName1;
		 
		 
		
		//create folder if not created
		 File f = new File(path);
		 if(!f.exists()) {
			 f.mkdir();
		 }
		
		//file copy
		 Files.copy(file.getInputStream(),Paths.get(filePath));
		return name;
	}

}
