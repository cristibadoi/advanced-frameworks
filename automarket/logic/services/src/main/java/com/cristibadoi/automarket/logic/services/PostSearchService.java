package com.cristibadoi.automarket.logic.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristibadoi.automarket.logic.converters.ModelConverter;
import com.cristibadoi.automarket.logic.converters.PostConverter;
import com.cristibadoi.automarket.logic.data.ModelData;
import com.cristibadoi.automarket.logic.data.PostData;
import com.cristibadoi.automarket.persistence.repositories.PostRepository;

@Service
public class PostSearchService {

  @Autowired
  PostRepository postRepository;

  @Autowired
  PostConverter postConverter;

  @Autowired
  ModelConverter modelConverter;

  public List<PostData> findByModel(ModelData model) {
    List<PostData> results = new ArrayList<PostData>();
    results.addAll(postConverter.convertPosts(postRepository.findByModel(modelConverter.convertModel(model))));
    return results;
  }

}