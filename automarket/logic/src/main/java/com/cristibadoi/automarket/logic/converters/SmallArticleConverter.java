package com.cristibadoi.automarket.logic.converters;

import com.cristibadoi.automarket.logic.data.SmallArticleData;
import com.cristibadoi.automarket.logic.services.ArticleImageService;
import com.cristibadoi.automarket.persistence.models.ArticleModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class SmallArticleConverter implements EntityConverter<ArticleModel, SmallArticleData> {

  @Autowired
  ArticleImageService articleImageService;

  @Override
  public SmallArticleData convertModelToData(ArticleModel article) {

    SmallArticleData smallArticleData = new SmallArticleData();

    smallArticleData.setId(article.getId());
    smallArticleData.setModelYear(article.getModelYear());
    smallArticleData.setMileage(article.getMileage());
    smallArticleData.setPrice(article.getPrice());
    smallArticleData.setPublicationDate(new Date((long) article.getPublicationDate() * 1000));
    smallArticleData.setCylindricalCapacity(article.getCylindricalCapacity());
    smallArticleData.setBrandName(article.getBrand().getName());
    smallArticleData.setModelName(article.getModel().getName());
    smallArticleData.setFuelName(article.getFuel().getName());
    smallArticleData.setCityName(article.getCity().getName());
    smallArticleData.setType(article.getType().getName());
    try {
      smallArticleData.setImageLink(articleImageService.getImageLinks(article).get(0));
    }
    catch (NullPointerException e) {
      //TODO log missing images for current article
    }

    return smallArticleData;
  }

  @Override
  public List<SmallArticleData> convertModelListToDataList(List<ArticleModel> list) {

    List<SmallArticleData> smallArticleDataList = new ArrayList<SmallArticleData>();
    for (ArticleModel articleModel : list) {
      smallArticleDataList.add(convertModelToData(articleModel));
    }

    return smallArticleDataList;

  }

}
