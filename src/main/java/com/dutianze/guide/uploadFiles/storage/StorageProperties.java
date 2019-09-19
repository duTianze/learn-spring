package com.dutianze.guide.uploadFiles.storage;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

/**
 * @author: dutianze
 * Date: 2019-09-17
 */
@Configuration("storage")
@Data
public class StorageProperties {

    private String location = "/Users/dutianze/test/1";
}
