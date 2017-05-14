package com.cristibadoi.automarket.web.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
  @GetMapping(value = "/{postId}/{imageName:.+}")
  public byte[] getImage(@PathVariable String postId, @PathVariable String imageName) {
    String absoluteImagePath = ServiceLayerConstants.IMAGES_PARENT_FOLDER + File.separator + postId + File.separator
        + imageName;
    byte[] results = null;
    try {
      InputStream in = new FileInputStream(absoluteImagePath);
      results = IOUtils.toByteArray(in);
    } catch (FileNotFoundException e) {
    } catch (IOException e) {
    }
    return results;
  }
}
