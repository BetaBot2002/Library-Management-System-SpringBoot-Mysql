package com.lms.librarymanagementsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.librarymanagementsystem.models.Fine;

public interface FineRepository extends JpaRepository<Fine,Integer> {
    @Query(value="SELECT * FROM FINE WHERE USERNAME=:USERNAME AND PAID IN ('false','requested','rejected')",nativeQuery = true)
    List<Fine> getUnpaidFineByUsername(@Param("USERNAME")String username);

    @Modifying
    @Query(value="UPDATE FINE SET PAID='requested' WHERE USERNAME=:USERNAME AND PAID='false'",nativeQuery = true)
    Integer setFineRequestedByUsername(@Param("USERNAME")String username);

    @Modifying
    @Query(value="UPDATE FINE SET PAID=:action WHERE USERNAME=:USERNAME AND PAID='requested'",nativeQuery = true)
    Integer setFineActionByUsername(@Param("USERNAME")String username,@Param("action")String action);
}
