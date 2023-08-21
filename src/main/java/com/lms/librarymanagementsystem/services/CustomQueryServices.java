package com.lms.librarymanagementsystem.services;

import java.util.List;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
public class CustomQueryServices {
    @PersistenceContext
    private EntityManager entityManager;

    public <T> List<T> executeCustomQuery(String sql, Class<T> resultClass) {
        Query nativeQuery = entityManager.createNativeQuery(sql, resultClass);
        List<T> results = nativeQuery.getResultList();
        return results;
    }
    
}

