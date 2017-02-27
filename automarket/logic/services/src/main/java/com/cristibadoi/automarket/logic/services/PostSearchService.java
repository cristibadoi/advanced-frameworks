package com.cristibadoi.automarket.logic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristibadoi.automarket.logic.converters.EntityConverter;
import com.cristibadoi.automarket.logic.data.PostData;
import com.cristibadoi.automarket.logic.query.QueryDetails;
import com.cristibadoi.automarket.persistence.models.PostModel;
import com.cristibadoi.automarket.persistence.repositories.PostRepository;

@Service
public class PostSearchService {

  @Autowired
  PostRepository postRepository;

  @Autowired
  EntityConverter<PostModel, PostData> postConverter;

  public List<PostData> getMatchingPosts(QueryDetails queryDetails) {
    //return postConverter.convertModelToDataList(result);
    return null;
  }

}