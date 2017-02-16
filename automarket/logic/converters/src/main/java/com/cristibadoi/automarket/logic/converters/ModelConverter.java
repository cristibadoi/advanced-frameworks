package com.cristibadoi.automarket.logic.converters;

import org.springframework.stereotype.Component;
import com.cristibadoi.automarket.logic.data.ModelData;
import com.cristibadoi.automarket.persistence.models.ModelModel;

@Component
public class ModelConverter {

  public ModelData convertModel(ModelModel model) {
    ModelData result = new ModelData();

    return result;
  }
  
  public ModelModel convertModel(ModelData post) {
    ModelModel result = new ModelModel();
    
    return result;
  }

}
