package com.cristibadoi.automarket.logic.services;

import com.cristibadoi.automarket.logic.input.QueryInput;
import com.querydsl.core.types.Predicate;

public interface ArticlePredicatesService {

  Predicate createArticleSearchPredicate(QueryInput queryInput);

  Predicate createUserPredicate(String username);

}
