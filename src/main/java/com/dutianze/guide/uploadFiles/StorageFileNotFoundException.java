package com.dutianze.guide.uploadFiles;

/**
 * @author: dutianze
 * Date: 2019-09-17
 */
public class StorageFileNotFoundException extends StorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
