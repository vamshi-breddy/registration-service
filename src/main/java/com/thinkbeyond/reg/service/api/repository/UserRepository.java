package com.thinkbeyond.reg.service.api.repository;

import com.thinkbeyond.reg.service.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByEmail(String email);
}
