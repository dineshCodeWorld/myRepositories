package com.example.fileuploaddownload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.fileuploaddownload.dto.ResponseData;
import com.example.fileuploaddownload.entity.Attachment;
import com.example.fileuploaddownload.service.AttachmentService;

@RestController
public class AttachmentController 
{
	@Autowired
  private AttachmentService attachmentService;
	
  @PostMapping("/upload")
  public ResponseData uploadFile(@RequestParam("file") MultipartFile file) throws Exception
  {
	 Attachment attachment =  attachmentService.saveAttachment(file);
	 String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/").path(attachment.getId()).toUriString();
	 
	  return new ResponseData(attachment.getFileName(),downloadUrl,file.getContentType(),file.getSize());
  }
  @GetMapping("/download/{fileId}")
  public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception
  {
	  Attachment attachment = attachmentService.getFile(fileId);
	  
	  return ResponseEntity.ok()
			  .contentType(MediaType.parseMediaType(attachment.getFileType()))
			  .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\"" +attachment.getFileName()
			  + "\"").body(new ByteArrayResource(attachment.getData()));
  }
}














