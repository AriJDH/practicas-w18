package com.socialmeli.be_java_hisp_w18g05.service;

import com.socialmeli.be_java_hisp_w18g05.repository.IRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceImp2 implements IService{
    IRepository repository;

    public ServiceImp2(IRepository repository) {
        this.repository = repository;
    }
}
