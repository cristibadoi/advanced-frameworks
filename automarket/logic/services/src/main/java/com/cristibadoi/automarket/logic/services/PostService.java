package com.cristibadoi.automarket.logic.services;

import java.util.List;

import com.cristibadoi.automarket.logic.data.PostData;
import com.cristibadoi.automarket.logic.query.QueryDetails;

public interface PostService {

  List<PostData> getMatchingPosts(QueryDetails queryDetails);

}
