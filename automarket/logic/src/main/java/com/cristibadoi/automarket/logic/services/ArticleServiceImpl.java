package com.cristibadoi.automarket.logic.services;

import com.cristibadoi.automarket.logic.constants.ServiceLayerConstants;
import com.cristibadoi.automarket.logic.converters.EntityConverter;
import com.cristibadoi.automarket.logic.data.FullArticleData;
import com.cristibadoi.automarket.logic.data.SmallArticleData;
import com.cristibadoi.automarket.logic.exceptions.ArticleNotFoundException;
import com.cristibadoi.automarket.logic.exceptions.UnauthorizedException;
import com.cristibadoi.automarket.logic.exceptions.UploadFailureException;
import com.cristibadoi.automarket.logic.input.PublishInput;
import com.cristibadoi.automarket.logic.input.QueryInput;
import com.cristibadoi.automarket.persistence.models.ArticleModel;
import com.cristibadoi.automarket.persistence.repositories.ArticleRepository;
import com.google.common.collect.Lists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

  @Autowired
  private ArticleRepository articleRepository;

  @Autowired
  private EntityConverter<ArticleModel, FullArticleData> fullArticleConverter;

  @Autowired
  private EntityConverter<ArticleModel, SmallArticleData> smallArticleConverter;

  @Autowired
  private ArticlePredicatesServiceImpl articlePredicatesServiceImpl;

  @Autowired
  private ArticleImageService articleImageService;

  @Autowired
  private ModelExtractorService modelExtractor;

  @Override
  @Transactional(readOnly = true)
  public List<FullArticleData> getMatchingFullArticles(QueryInput queryInput) {

    List<ArticleModel> results = Lists
        .newArrayList(articleRepository.findAll(articlePredicatesServiceImpl.createArticleSearchPredicate(queryInput)));

    return fullArticleConverter.convertModelListToDataList(results);

  }

  @Override
  @Transactional(readOnly = true)
  public FullArticleData getFullArticleById(long id) throws ArticleNotFoundException {

    ArticleModel result = articleRepository.findById(id);
    if (result == null || !result.getStatus().getName().equals(ServiceLayerConstants.ARTICLE_STATUS_ACTIVE)) {
      throw new ArticleNotFoundException(ServiceLayerConstants.ARTICLE_NOT_FOUND_MESSAGE);
    }

    return fullArticleConverter.convertModelToData(result);

  }

  @Override
  @Transactional(readOnly = true)
  public List<SmallArticleData> getMatchingSmallArticles(QueryInput queryInput) {

    List<ArticleModel> results = Lists
        .newArrayList(articleRepository.findAll(articlePredicatesServiceImpl.createArticleSearchPredicate(queryInput)));

    return smallArticleConverter.convertModelListToDataList(results);

  }

  @Override
  @Transactional(readOnly = true)
  public SmallArticleData getSmallArticleById(long id) throws ArticleNotFoundException {

    ArticleModel result = articleRepository.findById(id);
    if (result == null || !result.getStatus().getName().equals(ServiceLayerConstants.ARTICLE_STATUS_ACTIVE)) {
      throw new ArticleNotFoundException(ServiceLayerConstants.ARTICLE_NOT_FOUND_MESSAGE);
    }

    return smallArticleConverter.convertModelToData(result);

  }

  @Override
  @Transactional(readOnly = true)
  public List<SmallArticleData> getSmallArticlesByAuthor(String authorUsername) {

    List<ArticleModel> results = Lists
        .newArrayList(articleRepository.findAll(articlePredicatesServiceImpl.createUserPredicate(authorUsername)));

    return smallArticleConverter.convertModelListToDataList(results);

  }

  @Override
  @Transactional
  public void saveArticle(PublishInput publishInput) throws UploadFailureException {

    User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    long unixTime = new Date().getTime() / 1000;

    ArticleModel article = new ArticleModel();
    article.setUser(modelExtractor.findUserByUsername(currentUser.getUsername()));
    article.setBrand(modelExtractor.findBrandByName(publishInput.getBrand()));
    article.setModel(modelExtractor.findModelByName(publishInput.getModel()));
    article.setType(modelExtractor.findTypeByName(publishInput.getType()));
    article.setFuel(modelExtractor.findFuelByName(publishInput.getFuel()));
    article.setCity(modelExtractor.findCityByName(publishInput.getCity()));
    article.setStatus(modelExtractor.findStatusByName(ServiceLayerConstants.ARTICLE_STATUS_ACTIVE));
    article.setModelYear(publishInput.getYear());
    article.setCylindricalCapacity(publishInput.getCapacity());
    article.setMileage(publishInput.getMileage());
    article.setDescription(publishInput.getDescription());
    article.setPrice(publishInput.getPrice());
    article.setPhoneNumber(publishInput.getPhone());
    article.setEmail(publishInput.getEmail());
    article.setPublicationDate((int) unixTime);
    article = articleRepository.save(article);

    try {
      articleImageService.uploadImages(article, publishInput.getImages());
    } catch (UploadFailureException e) {
      articleRepository.delete(article.getId());
      throw e;
    }

    articleRepository.save(article);

  }

  @Override
  @Transactional
  public void deleteArticle(long id, String action) throws UnauthorizedException {

    User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String username = currentUser.getUsername();
    ArticleModel article = articleRepository.findById(id);

    if (!article.getUser().getUsername().equals(username)) {
      throw new UnauthorizedException(ServiceLayerConstants.UNAUTHORIZED_MESSAGE);
    }

    if (action.equalsIgnoreCase(ServiceLayerConstants.ARTICLE_ACTION_DELETE)) {
      article.setStatus(modelExtractor.findStatusByName(ServiceLayerConstants.ARTICLE_STATUS_DELETED));
      articleRepository.save(article);
    }
    if (action.equalsIgnoreCase(ServiceLayerConstants.ARTICLE_ACTION_MARK_AS_SOLD)) {
      article.setStatus(modelExtractor.findStatusByName(ServiceLayerConstants.ARTICLE_STATUS_SOLD));
      articleRepository.save(article);
    }

  }

}