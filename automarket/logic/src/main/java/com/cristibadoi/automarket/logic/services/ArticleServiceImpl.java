package com.cristibadoi.automarket.logic.services;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cristibadoi.automarket.logic.constants.ServiceLayerConstants;
import com.cristibadoi.automarket.logic.converters.EntityConverter;
import com.cristibadoi.automarket.logic.data.FullArticleData;
import com.cristibadoi.automarket.logic.exceptions.NoResultsFoundException;
import com.cristibadoi.automarket.logic.exceptions.ArticleNotFoundException;
import com.cristibadoi.automarket.logic.exceptions.UploadFailureException;
import com.cristibadoi.automarket.logic.input.ArticlePredicates;
import com.cristibadoi.automarket.logic.input.PublishInput;
import com.cristibadoi.automarket.logic.input.QueryInput;
import com.cristibadoi.automarket.persistence.models.ArticleModel;
import com.cristibadoi.automarket.persistence.repositories.ArticleRepository;
import com.google.common.collect.Lists;

@Service
public class ArticleServiceImpl implements ArticleService {

  @Autowired
  private ArticleRepository articleRepository;

  @Autowired
  private EntityConverter<ArticleModel, FullArticleData> postConverter;

  @Autowired
  private ArticlePredicates articlePredicates;

  @Autowired
  private ArticleImageService articleImageService;

  @Autowired
  private ModelExtractorService modelExtractor;

  @Override
  @Transactional(readOnly = true)
  public List<FullArticleData> getMatchingPosts(QueryInput queryInput) throws NoResultsFoundException {

    List<ArticleModel> results = Lists.newArrayList(
        articleRepository.findAll(articlePredicates.createPredicate(queryInput)));

    if (results.isEmpty()) {
      throw new NoResultsFoundException(ServiceLayerConstants.NO_MATCHING_RESULTS_MESSAGE);
    }

    return postConverter.convertModelToDataList(results);

  }

  @Override
  @Transactional(readOnly = true)
  public FullArticleData getPostById(long id) throws ArticleNotFoundException {

    ArticleModel result = articleRepository.findById(id);
    if (result == null) {
      throw new ArticleNotFoundException(ServiceLayerConstants.POST_NOT_FOUND_MESSAGE);
    }

    return postConverter.convertModelToData(result);

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
    article.setStatus(modelExtractor.findStatusByName(ServiceLayerConstants.POST_STATUS_ACTIVE));
    article.setModelYear(publishInput.getYear());
    article.setCylindricalCapacity(publishInput.getCapacity());
    article.setMileage(publishInput.getMileage());
    article.setDescription(publishInput.getDescription());
    article.setPrice(publishInput.getPrice());
    article.setPhoneNumber(publishInput.getPhone());
    article.setEmail(publishInput.getEmail());
    article.setPublicationDate((int) unixTime);
    article = articleRepository.save(article);

    File folder = new File(ServiceLayerConstants.IMAGES_PARENT_FOLDER + File.separator + article.getId());
    try {
      articleImageService.uploadImages(article, publishInput.getImages());
    } catch (UploadFailureException e) {
      articleRepository.delete(article.getId());
      throw e;
    }

    articleRepository.save(article);

  }

}