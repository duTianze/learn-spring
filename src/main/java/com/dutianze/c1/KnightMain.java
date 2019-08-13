package com.dutianze.c1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {

  public static void main(String[] args)  {
      ApplicationContext ctx = new ClassPathXmlApplicationContext("minstrel.xml", Knight.class);
      //AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(KnightConfig.class);
      Knight knight = ctx.getBean(Knight.class);
      knight.embarkOnQuest();
  }

}
