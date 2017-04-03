package com.cristibadoi.automarket.logic.converters;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cristibadoi.automarket.logic.data.PostData;
import com.cristibadoi.automarket.persistence.models.PostModel;

@Component
public class PostConverter implements EntityConverter<PostModel, PostData> {

  @Override
  public PostData convertModelToData(PostModel model) {
    PostData result = new PostData();
    result.setModelYear(model.getModelYear());
    result.setMileage(model.getMileage());
    result.setPrice(model.getPrice());
    result.setPhoneNumber(model.getPhoneNumber());
    result.setEmail(model.getEmail());
    result.setDescription(model.getDescription());
    result.setImages(model.getImages());
    result.setPublicationDate(model.getPublicationDate());
    result.setCylindricalCapacity(model.getCylindricalCapacity());
    result.setBrandName(model.getBrand().getName());
    result.setModelName(model.getModel().getName());
    result.setFuelName(model.getFuel().getName());
    result.setCityName(model.getCity().getName());
    result.setType(model.getType().getName());
    return result;
  }

  @Override
  public List<PostData> convertModelToDataList(List<PostModel> list) {
    List<PostData> result = new LinkedList<PostData>();
    for (PostModel p : list) {
      result.add(convertModelToData(p));
    }
    return result;
  }

}
