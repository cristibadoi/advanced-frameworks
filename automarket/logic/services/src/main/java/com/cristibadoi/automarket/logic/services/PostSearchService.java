package com.cristibadoi.automarket.logic.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cristibadoi.automarket.logic.data.PostData;
import com.cristibadoi.automarket.logic.query.QueryDetails;

@Service
public interface PostSearchService {

  List<PostData> getMatchingPosts(QueryDetails queryDetails);

}
