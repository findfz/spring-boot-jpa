package com.common.user.repository;

import com.common.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author：xiongzhan
 * Description：用户repository
 * Date: 2018-07-25 23:17
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
