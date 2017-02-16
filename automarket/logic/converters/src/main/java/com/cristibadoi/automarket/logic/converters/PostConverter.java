package com.cristibadoi.automarket.logic.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cristibadoi.automarket.logic.data.PostData;
import com.cristibadoi.automarket.persistence.models.PostModel;

@Component
public class PostConverter {

  public PostData convertPost(PostModel post) {
    PostData result = new PostData();
    
    return result;
  }
  
  public List<PostData> convertPosts(List<PostModel> posts) {
    List<PostData> result = new ArrayList<PostData>();
    
    for (PostModel p : posts) {
      result.add(convertPost(p));
    }
    
    return result;
  }
  
}
