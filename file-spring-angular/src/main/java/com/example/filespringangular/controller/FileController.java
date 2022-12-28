package com.example.filespringangular.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController 
{
  public static final String DIRECTORY = System.getProperty("user.home") + "/";
  
  @PostMapping("/upload")
  public ResponseEntity<List<String>> uploadFiles(@RequestParam("files") List<MultipartFile> multipartFiles) throws IOException
  {
	  List<String> fileNames = new ArrayList<>();
	  for(MultipartFile file:multipartFiles)
	  {
		  String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		  Path path = Paths.get(DIRECTORY,fileName).toAbsolutePath().normalize();
          Files.copy(file.getInputStream(), path,StandardCopyOption.REPLACE_EXISTING);
          fileNames.add(fileName);
	  }
	  return ResponseEntity.ok().body(fileNames);
  }
  
  @GetMapping("/download/{filename}")
  public ResponseEntity<Resource> downloadFiles(@PathVariable("filename") String fileName) throws IOException
  {
	  Path path = Paths.get(DIRECTORY).toAbsolutePath().normalize().resolve(fileName);
	  if(!Files.exists(path))
	  {
		throw new FileNotFoundException(fileName + "was not found");  
	  }
	  Resource resource = new UrlResource(path.toUri());
	  HttpHeaders headers = new HttpHeaders();
	  headers.add("fileName", fileName);
	  headers.add(HttpHeaders.CONTENT_DISPOSITION,"attachment; "+ fileName);
	  return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(path))).headers(headers).body(resource);
  }
}






















