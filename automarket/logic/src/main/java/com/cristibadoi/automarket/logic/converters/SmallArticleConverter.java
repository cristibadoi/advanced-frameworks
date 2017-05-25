package com.cristibadoi.automarket.logic.converters;

import com.cristibadoi.automarket.logic.data.SmallArticleData;
import com.cristibadoi.automarket.logic.services.ArticleImageService;
import com.cristibadoi.automarket.persistence.models.ArticleModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SmallArticleConverter implements EntityConverter<ArticleModel, SmallArticleData> {

  @Autowired
  ArticleImageService articleImageService;

  @Override
  public SmallArticleData convertModelToData(ArticleModel model) {

    SmallArticleData smallArticleData = new SmallArticleData();
    smallArticleData.setModelYear(model.getModelYear());
    smallArticleData.setMileage(model.getMileage());
    smallArticleData.setPrice(model.getPrice());
    smallArticleData.setImageLink(articleImageService.getImageLinks(model).get(0));
    smallArticleData.setPublicationDate(model.getPublicationDate());
    smallArticleData.setCylindricalCapacity(model.getCylindricalCapacity());
    smallArticleData.setBrandName(model.getBrand().getName());
    smallArticleData.setModelName(model.getModel().getName());
    smallArticleData.setFuelName(model.getFuel().getName());
    smallArticleData.setCityName(model.getCity().getName());
    smallArticleData.setType(model.getType().getName());

    return smallArticleData;
  }

  @Override
  public List<SmallArticleData> convertModelToDataList(List<ArticleModel> list) {

    List<SmallArticleData> smallArticleDataList = new ArrayList<SmallArticleData>();
    for (ArticleModel articleModel : list) {
      smallArticleDataList.add(convertModelToData(articleModel));
    }

    return smallArticleDataList;
    
  }

}
