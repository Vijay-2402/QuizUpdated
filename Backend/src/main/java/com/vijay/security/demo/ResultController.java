package com.vijay.security.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ResultController {

    @Autowired
    ResultRepository repository;
    @GetMapping("/result")
    public List<Result> getResult(){
        List<Result>allResult=repository.findAll();
        return allResult;
    }

@PostMapping("/result/update")
@PreAuthorize("hasAuthority('admin:update')")
public Result updateResult(@RequestBody Result updatedResult){
  return repository.save(updatedResult);
}
}