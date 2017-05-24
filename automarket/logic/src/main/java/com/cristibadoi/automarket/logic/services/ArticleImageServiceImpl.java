package com.cristibadoi.automarket.logic.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cristibadoi.automarket.logic.constants.ServiceLayerConstants;
import com.cristibadoi.automarket.logic.exceptions.UploadFailureException;
import com.cristibadoi.automarket.persistence.models.ArticleModel;
import com.querydsl.core.util.FileUtils;

@Service
public class ArticleImageServiceImpl implements ArticleImageService {

  @Override
  public void uploadImages(ArticleModel article, MultipartFile[] images) throws UploadFailureException {

    File uploadFolder = new File(ServiceLayerConstants.IMAGES_PARENT_FOLDER + File.separator + article.getId());

    if (!uploadFolder.exists()) {
      uploadFolder.mkdirs();
    }

    for (int i = 0; i < images.length; i++) {
      MultipartFile image = images[i];
      String fileName = image.getOriginalFilename();
      try {
        byte[] bytes = image.getBytes();
        File serverFile = new File(uploadFolder.getAbsolutePath() + File.separator + fileName);
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
        stream.write(bytes);
        stream.close();
      } catch (IOException e) {
        deleteFolder(uploadFolder);
        throw new UploadFailureException(e.getMessage());
      }
    }

  }

  @Override
  public List<String> getImageLinks(ArticleModel article) {

    List<String> result = new ArrayList<String>();
    File imagesFolder = new File(ServiceLayerConstants.IMAGES_PARENT_FOLDER + File.separator + article.getId());
    for (String imageName : imagesFolder.list()) {
      result.add(article.getId() + File.separator + imageName);
    }

    return result;

  }

  private void deleteFolder(File folder) {
    try {
      FileUtils.delete(folder);
    } catch (IOException e) {
      //TO DO log failure to delete remnant files
    }
  }

}
