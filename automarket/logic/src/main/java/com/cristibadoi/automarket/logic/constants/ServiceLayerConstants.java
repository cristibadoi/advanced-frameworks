package com.cristibadoi.automarket.logic.constants;

import java.io.File;

public class ServiceLayerConstants {

  public static final String APP_IMAGE_FOLDER = "automarket-images";
  public static final String TOMCAT_HOME = "catalina.home";
  public static final String IMAGES_PARENT_FOLDER = System.getProperty(TOMCAT_HOME) + File.separator + APP_IMAGE_FOLDER;

  public static final String IMAGE_UPLOAD_FAILURE_MESSAGE = "Your files failed to upload!";
  public static final String IMAGE_DOWNLOAD_FAILURE_MESSAGE = "Image unavailable!";
  public static final String NO_MATCHING_RESULTS_MESSAGE = "No matching results found!";
  public static final String ARTICLE_NOT_FOUND_MESSAGE = "Article not found!";
  public static final String UNAUTHORIZED_MESSAGE = "UNAUTHORIZED ACTION";
      
  public static final String ARTICLE_STATUS_ACTIVE = "ACTIVE";
  public static final String ARTICLE_STATUS_DELETED = "DELETED";
  public static final String ARTICLE_STATUS_SOLD = "SOLD";

  public static final String ARTICLE_ACTION_DELETE = "delete";
  public static final String ARTICLE_ACTION_MARK_AS_SOLD = "sold";
  
}
