package com.lms.librarymanagementsystem.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lms.librarymanagementsystem.models.Fine;
import com.lms.librarymanagementsystem.repositories.FineRepository;

@Service
@Transactional
public class FineServices {
    private FineRepository fineRepository;

    public FineServices(FineRepository fineRepository) {
        this.fineRepository = fineRepository;
    }

    public Fine inserOneFine(Fine fine){
        return fineRepository.save(fine);
    }

    public List<Fine> findUnpaidFineByUsername(String username){
        return fineRepository.getUnpaidFineByUsername(username);
    }

    public Integer updateFineToRequested(String username){
        return fineRepository.setFineRequestedByUsername(username);
    }

    public Integer updateFineToAction(String username,String action){
        return fineRepository.setFineActionByUsername(username,action);
    }
}
