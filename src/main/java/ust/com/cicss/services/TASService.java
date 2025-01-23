package ust.com.cicss.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ust.com.cicss.dao.TASRepository;

@Service
public class TASService {

    @Autowired
    private TASRepository tasRepo;

    public boolean authByEmail(String email){
        
        return tasRepo.authByEmail(email);
    }
}
