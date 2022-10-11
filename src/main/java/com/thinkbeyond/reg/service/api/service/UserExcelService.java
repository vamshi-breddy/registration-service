package com.thinkbeyond.reg.service.api.service;

import com.thinkbeyond.reg.service.api.entity.UserRegDetails;
import com.thinkbeyond.reg.service.api.helper.ExcelHelper;
import com.thinkbeyond.reg.service.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class UserExcelService {

    @Autowired
    private UserRepository userRepository;

    public void save(MultipartFile file) throws IOException {
        try {
            List<UserRegDetails> userList = ExcelHelper.convertExcelToList(file.getInputStream());
            this.userRepository.saveAll(userList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<UserRegDetails> getAllUsers(){
         return this.userRepository.findAll();
    }

}
