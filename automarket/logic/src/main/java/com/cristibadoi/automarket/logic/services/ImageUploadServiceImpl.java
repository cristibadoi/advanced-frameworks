package com.cristibadoi.automarket.logic.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cristibadoi.automarket.logic.exceptions.UploadFailureException;

@Service
public class ImageUploadServiceImpl implements ImageUploadService {

  @Override
  public void uploadFiles(File folder, MultipartFile[] images) throws UploadFailureException {

    if (!folder.exists()) {
      folder.mkdirs();
    }

    for (int i = 0; i < images.length; i++) {
      MultipartFile image = images[i];
      String fileName = image.getOriginalFilename();
      try {
        byte[] bytes = image.getBytes();
        File serverFile = new File(folder.getAbsolutePath() + File.separator + fileName);
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
        stream.write(bytes);
        stream.close();
      } catch (Exception e) {
        throw new UploadFailureException("");
      }
    }

  }

}
