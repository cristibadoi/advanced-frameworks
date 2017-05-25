package com.cristibadoi.automarket.web.controllers;

import com.cristibadoi.automarket.logic.constants.ServiceLayerConstants;
import com.cristibadoi.automarket.logic.exceptions.DownloadFailureException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;

@Controller
@RequestMapping("/images")
public class ImageController {

  @Autowired
  ServletContext servletContext;

  @ResponseBody
  @GetMapping(value = "/{articleId}/{imageName:.+}")
  public byte[] getImage(@PathVariable String articleId, @PathVariable String imageName)
      throws DownloadFailureException {

    String absoluteImagePath = ServiceLayerConstants.IMAGES_PARENT_FOLDER + File.separator + articleId + File.separator
                               + imageName;
    byte[] results = null;
    try {
      InputStream in = new FileInputStream(absoluteImagePath);
      results = IOUtils.toByteArray(in);
    } catch (IOException e) {
      throw new DownloadFailureException(ServiceLayerConstants.IMAGE_DOWNLOAD_FAILURE_MESSAGE);
    }

    return results;

  }

}
