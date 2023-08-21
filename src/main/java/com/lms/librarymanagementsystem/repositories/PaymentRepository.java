package com.lms.librarymanagementsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.librarymanagementsystem.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {

    @Query(value="SELECT * FROM PAYMENT WHERE APPROVED='pending' AND TYPE='fine'",nativeQuery = true)
    List<Payment> getPendingFinePayments();

    @Query(value="SELECT * FROM PAYMENT WHERE USERNAME=:username AND APPROVED='pending' AND TYPE='fine'",nativeQuery = true)
    List<Payment> getPendingFinePaymentsByUsername(@Param("username")String username);
    
    @Query(value="SELECT * FROM PAYMENT WHERE APPROVED='pending' AND TYPE='renewal'",nativeQuery = true)
    List<Payment> getPendingRenewalPayments();
    
    @Query(value="SELECT * FROM PAYMENT WHERE USERNAME=:username AND  APPROVED='pending' AND TYPE='renewal'",nativeQuery = true)
    List<Payment> getPendingRenewalPaymentsByUsername(@Param("username")String username);

    @Modifying
    @Query(value="UPDATE PAYMENT SET APPROVED=:action WHERE PID=:pid",nativeQuery = true)
    Integer updatePaymentByPid(@Param("pid")String pid,@Param("action")String action);
    
}
