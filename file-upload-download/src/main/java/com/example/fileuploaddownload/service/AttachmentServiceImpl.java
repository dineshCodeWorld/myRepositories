package com.example.fileuploaddownload.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.fileuploaddownload.dto.ResponseData;
import com.example.fileuploaddownload.entity.Attachment;
import com.example.fileuploaddownload.repository.AttachmentRepo;

@Service
public class AttachmentServiceImpl implements AttachmentService
{
	@Autowired
	private AttachmentRepo attachmentRepo;
	
	@Override
	public Attachment saveAttachment(MultipartFile file) throws Exception
	{
      String fileName = StringUtils.cleanPath(file.getOriginalFilename());
      try {
		if(fileName.contains(".."))
		{
			throw new Exception("File name contains invalid path");
		}
		
		Attachment attachment = new Attachment(fileName,file.getContentType(),file.getBytes());
		return attachmentRepo.save(attachment);
	} catch (Exception e) {
		throw new Exception("Could not save file "+fileName);
	}
	}

	@Override
	public Attachment getFile(String fileId) throws Exception {
        return attachmentRepo.findById(fileId).orElseThrow(()->new Exception("file not found"));
	}

}
