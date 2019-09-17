package com.dutianze.guide.uploadFiles;

/**
 * @author: dutianze
 * Date: 2019-09-17
 */
public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
