package com.example.cicss.service;

import com.example.cicss.dao.TASRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TASService {

    @Autowired
    private TASRepository tasRepo;

    public boolean authByEmail(String email){

        return tasRepo.authByEmail(email);
    }
}
