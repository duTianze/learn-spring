package com.dutianze.guide.uploadFiles.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @author: dutianze
 * Date: 2019-09-17
 */
public interface StorageService {

    void init();

    void store(MultipartFile file);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void download(HttpServletResponse response);

    void deleteAll();
}
