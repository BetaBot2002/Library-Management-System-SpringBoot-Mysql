package com.lms.librarymanagementsystem.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lms.librarymanagementsystem.models.Alternative;
import com.lms.librarymanagementsystem.repositories.AlternativeRepository;

@Service
@Transactional
public class AlternativeServices {
    private AlternativeRepository alternativeRepository;

    public AlternativeServices(AlternativeRepository alternativeRepository) {
        this.alternativeRepository = alternativeRepository;
    }

    public Alternative insertOneAlternative(Alternative alternative){
        return alternativeRepository.save(alternative);
    }
    

}
