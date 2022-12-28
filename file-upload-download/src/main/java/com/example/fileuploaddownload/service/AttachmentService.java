package com.example.fileuploaddownload.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.fileuploaddownload.dto.ResponseData;
import com.example.fileuploaddownload.entity.Attachment;

public interface AttachmentService {
    Attachment saveAttachment(MultipartFile file) throws Exception;

	Attachment getFile(String fileId) throws Exception;

}
