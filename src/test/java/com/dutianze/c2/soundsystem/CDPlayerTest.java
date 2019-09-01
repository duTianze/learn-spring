package com.dutianze.c2.soundsystem;

import com.dutianze.c2.soundsystem.configuration.CDPlayerConfig;
import com.dutianze.c2.soundsystem.service.CD;
import com.dutianze.c2.soundsystem.service.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest  {

    @Autowired
    private CD cd;
    @Autowired
    private Player player;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
        cd.play();
    }

    @Test
    public void play() {
        player.play();
    }
}
