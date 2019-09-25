package com.dutianze.guide.mysql;

import org.springframework.data.repository.CrudRepository;

/**
 *  This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
 *  CRUD refers Create, Read, Update, Delete
 * @author: dutianze
 * Date: 2019-09-25
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
