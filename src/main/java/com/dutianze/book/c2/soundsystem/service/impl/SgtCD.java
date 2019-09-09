package com.dutianze.book.c2.soundsystem.service.impl;

import com.dutianze.book.c2.soundsystem.service.CD;
import org.springframework.stereotype.Component;

@Component("lonelyHeartsClub")
public class SgtCD implements CD {

  private String title = "Sgt. Pepper's Lonely Hearts Club Band";  
  private String artist = "The Beatles";
  
  public void play() {
    System.out.println("Playing " + title + " by " + artist);
  }
  
}
