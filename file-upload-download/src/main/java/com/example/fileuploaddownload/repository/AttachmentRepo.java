package com.example.fileuploaddownload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.fileuploaddownload.entity.Attachment;
@Repository
public interface AttachmentRepo extends  JpaRepository<Attachment, String>
{

}
