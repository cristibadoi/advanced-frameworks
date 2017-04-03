package com.cristibadoi.automarket.logic.services;

import java.util.List;

import com.cristibadoi.automarket.logic.data.PostData;
import com.cristibadoi.automarket.logic.exceptions.NoResultsFoundException;
import com.cristibadoi.automarket.logic.exceptions.PostNotFoundException;
import com.cristibadoi.automarket.logic.query.QueryDetails;
import com.cristibadoi.automarket.persistence.models.PostModel;

public interface PostService {

  PostData getPostById(long id) throws PostNotFoundException;

  List<PostData> getMatchingPosts(QueryDetails queryDetails) throws NoResultsFoundException;
  
  void save(PostModel post);
}
