package com.thinkbeyond.reg.service.api.repository;

import com.thinkbeyond.reg.service.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSecurityRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
