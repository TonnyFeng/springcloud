package com.jjy.repository;

import com.jjy.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by fengwei on 2018/4/24.
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long>, JpaSpecificationExecutor {
}
