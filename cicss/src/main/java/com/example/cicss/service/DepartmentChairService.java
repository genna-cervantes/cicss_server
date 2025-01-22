package com.example.cicss.service;

import com.example.cicss.dao.DepartmentChairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentChairService {

    @Autowired
    private DepartmentChairRepository depChairRepo;
}
