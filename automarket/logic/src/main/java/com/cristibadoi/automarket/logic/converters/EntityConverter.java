package com.cristibadoi.automarket.logic.converters;

import java.util.List;

public interface EntityConverter <M, D> {

  D convertModelToData(M model);
  
  List<D> convertModelListToDataList(List<M> list);
  
}