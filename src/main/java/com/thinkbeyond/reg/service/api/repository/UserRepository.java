package com.thinkbeyond.reg.service.api.repository;

import com.thinkbeyond.reg.service.api.entity.UserRegDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<UserRegDetails,Integer> {
    List<UserRegDetails> findByEmail(String email);
}
