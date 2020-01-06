package com.dutianze.kafka;

import lombok.Data;

import java.util.Date;

/**
 * @author: dutianze
 * Date: 2020-01-03
 */
@Data
public class Message {

    private String id;

    private String msg;

    private Date sendTime;

}
