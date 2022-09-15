package com.thinkbeyond.reg.service.api.service;

import com.thinkbeyond.reg.service.api.entity.User;
import com.thinkbeyond.reg.service.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserRegistrationService {

    @Autowired
    private UserRepository repository;

    public String register(User user) {
        repository.save(user);
        return "Hi " + user.getName() + " your Registration process successfully completed";
    }

    public List<User> findAllUsers() {
        return repository.findAll();
    }

    public List<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public List<User> cancelRegistration(int id) {
        repository.deleteById(id);
        return repository.findAll();
    }

}
