package com.c1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {

    @Autowired
    Knight knight;

  public static void main(String[] args) throws Exception {
    ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext(
                "com/c1/knight.xml");
    Knight knight = context.getBean(Knight.class);
    knight.embarkOnQuest();
    context.close();
  }

}
