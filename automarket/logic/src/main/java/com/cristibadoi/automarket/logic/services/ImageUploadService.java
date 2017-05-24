package com.cristibadoi.automarket.logic.services;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import com.cristibadoi.automarket.logic.exceptions.UploadFailureException;

public interface ImageUploadService {

  void uploadFiles(File folder, MultipartFile[] images) throws UploadFailureException;
  
}
