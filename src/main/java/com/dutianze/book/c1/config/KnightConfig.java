package com.dutianze.book.c1.config;

import com.dutianze.book.c1.SlayDragonQuest;
import com.dutianze.book.c1.BraveKnight;
import com.dutianze.book.c1.Knight;
import com.dutianze.book.c1.Quest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KnightConfig {

  @Bean
  public Knight knight() {
    return new BraveKnight(quest());
  }
  
  @Bean
  public Quest quest() {
    return new SlayDragonQuest(System.out);
  }

}
