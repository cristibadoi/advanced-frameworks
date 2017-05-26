package com.cristibadoi.automarket.logic.converters;

import com.cristibadoi.automarket.logic.data.FullArticleData;
import com.cristibadoi.automarket.logic.services.ArticleImageService;
import com.cristibadoi.automarket.persistence.models.ArticleModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Component
public class FullArticleConverter implements EntityConverter<ArticleModel, FullArticleData> {

  @Autowired
  private ArticleImageService articleImageService;

  @Override
  public FullArticleData convertModelToData(ArticleModel article) {

    FullArticleData result = new FullArticleData();

    result.setId(article.getId());
    result.setModelYear(article.getModelYear());
    result.setMileage(article.getMileage());
    result.setPrice(article.getPrice());
    result.setPhoneNumber(article.getPhoneNumber());
    result.setEmail(article.getEmail());
    result.setDescription(article.getDescription());
    result.setPublicationDate(new Date((long) article.getPublicationDate() * 1000));
    result.setCylindricalCapacity(article.getCylindricalCapacity());
    result.setImageLinks(articleImageService.getImageLinks(article));
    result.setUserName(article.getUser().getUsername());
    result.setBrandName(article.getBrand().getName());
    result.setModelName(article.getModel().getName());
    result.setFuelName(article.getFuel().getName());
    result.setCityName(article.getCity().getName());
    result.setTypeName(article.getType().getName());

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
