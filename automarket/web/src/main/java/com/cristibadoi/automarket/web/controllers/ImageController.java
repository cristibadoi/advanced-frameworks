package com.cristibadoi.automarket.web.controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cristibadoi.automarket.logic.constants.ServiceLayerConstants;

@Controller
@RequestMapping("/images")
public class ImageController {

  @Autowired
  ServletContext servletContext;

  @ResponseBody
  @GetMapping(value = "/{folderPath}/{imageId}")
  public byte[] getImage(@PathVariable String folderPath, @PathVariable String imageId) {
    String absoluteImagePath = System.getProperty(ServiceLayerConstants.CATALINA_HOME) + File.separator
        + ServiceLayerConstants.LOCAL_IMAGES_PARENT_FOLDER + File.separator + folderPath + File.separator + imageId;
    InputStream in = servletContext.getResourceAsStream(absoluteImagePath);
    System.out.println(absoluteImagePath);
    byte[] results = null;
    try {
      results = IOUtils.toByteArray(in);
    } catch (IOException e) {
    }
    return results;
  }
}
