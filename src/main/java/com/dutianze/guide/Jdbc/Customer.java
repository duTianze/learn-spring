package com.dutianze.guide.Jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: dutianze
 * Date: 2019-09-16
 */
@Data
@AllArgsConstructor
public class Customer {
    private long id;
    private String firstName;
    private String lastName;
}
