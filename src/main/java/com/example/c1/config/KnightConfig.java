package com.example.c1.config;

import com.example.c1.BraveKnight;
import com.example.c1.Knight;
import com.example.c1.Quest;
import com.example.c1.SlayDragonQuest;
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
