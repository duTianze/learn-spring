package com.dutianze.c1;

import com.dutianze.c1.config.KnightConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class KnightMain {

  public static void main(String[] args)  {
      //ApplicationContext ctx = new ClassPathXmlApplicationContext("minstrel.xml", Knight.class);
      AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(KnightConfig.class);
      Knight knight = ctx.getBean(Knight.class);
      knight.embarkOnQuest();
  }

}
