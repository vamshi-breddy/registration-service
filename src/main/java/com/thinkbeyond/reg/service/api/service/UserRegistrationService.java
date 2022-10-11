package com.thinkbeyond.reg.service.api.service;

import com.thinkbeyond.reg.service.api.entity.UserRegDetails;
import com.thinkbeyond.reg.service.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRegistrationService {

    @Autowired
    private UserRepository repository;

    public String register(UserRegDetails user) {
        repository.save(user);
        return "Hi " + user.getName() + " your Registration process successfully completed";
    }

    public List<UserRegDetails> findAllUsers() {
        return repository.findAll();
    }

    public List<UserRegDetails> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public List<UserRegDetails> cancelRegistration(int id) {
        repository.deleteById(id);
        return repository.findAll();
    }

}
