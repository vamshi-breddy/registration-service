package com.thinkbeyond.reg.service.api.controller;

import com.thinkbeyond.reg.service.api.entity.UserRegDetails;
import com.thinkbeyond.reg.service.api.helper.ExcelHelper;
import com.thinkbeyond.reg.service.api.service.UserExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class ExcelUploadController {

    @Autowired
    private UserExcelService userExcelService;

    @PostMapping("/user/upload")
    public ResponseEntity<?> uploadExcel(@RequestParam("file") MultipartFile file) throws IOException {

        if(ExcelHelper.checkExcelFormat(file)){

            this.userExcelService.save(file);

            return ResponseEntity.ok(Map.of("message","File is uploaded and data is saved"));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Upload Excel file");
    }

    @GetMapping("/getUsers")
    public List<UserRegDetails> getUsers(){
        return this.userExcelService.getAllUsers();
    }

}
