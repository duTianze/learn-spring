package com.dutianze.guide.asyncGithub;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author: dutianze
 * Date: 2019-09-25
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String name;
    private String blog;
}
