package ust.com.cicss.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ust.com.cicss.dao.DepartmentChairRepository;

@Service
public class DepartmentChairService {

    @Autowired
    private DepartmentChairRepository depChairRepo;

    public boolean authByEmail(String email) throws Exception{
        try{
            depChairRepo.authByEmail(email);
        }catch(Exception e){
            System.out.println(e);
        }

        return true;
    }
}
