package com.cristibadoi.automarket.logic.converters;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cristibadoi.automarket.logic.data.FullArticleData;
import com.cristibadoi.automarket.logic.services.ArticleImageService;
import com.cristibadoi.automarket.persistence.models.ArticleModel;

@Component
public class ArticleConverter implements EntityConverter<ArticleModel, FullArticleData> {

  @Autowired
  private ArticleImageService articleImageService;

  @Override
  public FullArticleData convertModelToData(ArticleModel article) {
    FullArticleData result = new FullArticleData();
    result.setModelYear(article.getModelYear());
    result.setMileage(article.getMileage());
    result.setPrice(article.getPrice());
    result.setPhoneNumber(article.getPhoneNumber());
    result.setEmail(article.getEmail());
    result.setDescription(article.getDescription());
    result.setPublicationDate(article.getPublicationDate());
    result.setCylindricalCapacity(article.getCylindricalCapacity());
    result.setBrandName(article.getBrand().getName());
    result.setModelName(article.getModel().getName());
    result.setFuelName(article.getFuel().getName());
    result.setCityName(article.getCity().getName());
    result.setType(article.getType().getName());
    result.setImages(articleImageService.getImageLinks(article));
    return result;
  }

  @Override
  public List<FullArticleData> convertModelToDataList(List<ArticleModel> list) {
    List<FullArticleData> result = new LinkedList<FullArticleData>();
    for (ArticleModel a : list) {
      result.add(convertModelToData(a));
    }
    return result;
  }

}
