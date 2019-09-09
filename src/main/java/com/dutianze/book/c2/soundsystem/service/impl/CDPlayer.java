package com.dutianze.book.c2.soundsystem.service.impl;
import com.dutianze.book.c2.soundsystem.service.CD;
import com.dutianze.book.c2.soundsystem.service.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements Player {
  private CD cd;

  @Autowired
  public CDPlayer(CD cd) {
    this.cd = cd;
  }

  public void play() {
    cd.play();
  }

}
