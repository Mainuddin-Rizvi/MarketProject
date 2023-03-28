package com.market.admin.user;

import com.market.common.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    @Query("Select u FROM User u WHERE u.email = :email")
    public User getUserByEmail(@Param("email") String email);
}
