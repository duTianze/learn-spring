package com.dutianze.guide.consumeRESTFul;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author: dutianze
 * Date: 2019-09-12
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {

    private long id;
    private String quote;
}
