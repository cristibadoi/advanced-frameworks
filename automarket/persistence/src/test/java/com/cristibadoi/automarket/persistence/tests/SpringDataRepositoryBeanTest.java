package com.cristibadoi.automarket.persistence.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cristibadoi.automarket.persistence.configuration.JPAConfig;
import com.cristibadoi.automarket.persistence.repositories.UtilizatorRepository;

public class SpringDataRepositoryBeanTest {

  private ApplicationContext ctx;
  
  @Before
  public void init() {
    ctx = new AnnotationConfigApplicationContext(JPAConfig.class);
  }
  
  @After
  public void finalize(){
    ((AnnotationConfigApplicationContext) ctx).close();
  }
  
  @Test
  public void testSpringShouldReturnRepositoryBean() {
    assertNotNull(ctx.getBean(UtilizatorRepository.class));
  }
}