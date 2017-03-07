package com.cristibadoi.automarket.logic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristibadoi.automarket.logic.converters.EntityConverter;
import com.cristibadoi.automarket.logic.data.PostData;
import com.cristibadoi.automarket.logic.query.PostPredicates;
import com.cristibadoi.automarket.logic.query.QueryDetails;
import com.cristibadoi.automarket.persistence.models.PostModel;
import com.cristibadoi.automarket.persistence.repositories.PostRepository;
import com.google.common.collect.Lists;

@Service
public class PostSearchService {

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private EntityConverter<PostModel, PostData> postConverter;

  @Autowired
  private PostPredicates postPredicates;

  public List<PostData> getMatchingPosts(QueryDetails queryDetails) {
    List<PostModel> modelList = Lists
        .newArrayList(postRepository.findAll(postPredicates.createPredicate(queryDetails)));
    List<PostData> result = postConverter.convertModelToDataList(modelList);
    return result;
  }

}