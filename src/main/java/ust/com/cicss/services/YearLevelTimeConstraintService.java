package ust.com.cicss.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ust.com.cicss.dao.YearLevelTimeConstraintRepository;
import ust.com.cicss.models.YearLevelTimeConstraint;
import ust.com.cicss.models.YearLevelTimeConstraintDTO;

@Service
public class YearLevelTimeConstraintService {

    @Autowired
    YearLevelTimeConstraintRepository repo;

    public YearLevelTimeConstraintDTO getYLTC(String department, int yearLevel) {
        YearLevelTimeConstraint yltc = repo.getYLTC(department, yearLevel);
        YearLevelTimeConstraintDTO yltcdto = new YearLevelTimeConstraintDTO(
                yltc.getYearLevelTimeConstraintId(),
                yltc.getRestrictions()
        );
        return yltcdto;
    }
}
