package com.cristibadoi.automarket.logic.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cristibadoi.automarket.logic.exceptions.UploadFailureException;
import com.cristibadoi.automarket.persistence.models.ArticleModel;

public interface ArticleImageService {

  void uploadImages(ArticleModel article, MultipartFile[] images) throws UploadFailureException;

  List<String> getImageLinks(ArticleModel article);

}
