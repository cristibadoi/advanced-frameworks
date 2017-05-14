package com.cristibadoi.automarket.logic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cristibadoi.automarket.logic.constants.ServiceLayerConstants;
import com.cristibadoi.automarket.logic.converters.EntityConverter;
import com.cristibadoi.automarket.logic.data.PostData;
import com.cristibadoi.automarket.logic.exceptions.NoResultsFoundException;
import com.cristibadoi.automarket.logic.exceptions.PostNotFoundException;
import com.cristibadoi.automarket.logic.query.PostPredicates;
import com.cristibadoi.automarket.logic.query.QueryDetails;
import com.cristibadoi.automarket.persistence.models.PostModel;
import com.cristibadoi.automarket.persistence.repositories.PostRepository;
import com.google.common.collect.Lists;

@Service
public class PostServiceImpl implements PostService {

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private EntityConverter<PostModel, PostData> postConverter;

  @Autowired
  private PostPredicates postPredicates;

  @Override
  @Transactional(readOnly = true)
  public List<PostData> getMatchingPosts(QueryDetails queryDetails) throws NoResultsFoundException {

    List<PostModel> results = Lists.newArrayList(postRepository.findAll(postPredicates.createPredicate(queryDetails)));

    if (results.isEmpty()) {
      throw new NoResultsFoundException(ServiceLayerConstants.NO_MATCHING_RESULTS_MESSAGE);
    }

    return postConverter.convertModelToDataList(results);

  }

  @Override
  @Transactional(readOnly = true)
  public PostData getPostById(long id) throws PostNotFoundException {

    PostModel result = postRepository.findById(id);
    if (result == null) {
      throw new PostNotFoundException(ServiceLayerConstants.POST_NOT_FOUND_MESSAGE);
    }

    return postConverter.convertModelToData(result);

  }

  @Override
  @Transactional
  public PostModel save(PostModel post) {
    return postRepository.save(post);
  }

}