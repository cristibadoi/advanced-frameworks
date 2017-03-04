package com.cristibadoi.automarket.logic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristibadoi.automarket.logic.converters.EntityConverter;
import com.cristibadoi.automarket.logic.data.PostData;
import com.cristibadoi.automarket.persistence.models.PostModel;
import com.cristibadoi.automarket.persistence.models.QPostModel;
import com.cristibadoi.automarket.persistence.repositories.PostRepository;
import com.querydsl.core.BooleanBuilder;

@Service
public class PostSearchService {

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private EntityConverter<PostModel, PostData> postConverter;

  public List<PostData> getMatchingPosts(QueryDetails queryDetails) {
    
  
    return null;
  }

}