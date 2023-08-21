package com.lms.librarymanagementsystem.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lms.librarymanagementsystem.models.Payment;
import com.lms.librarymanagementsystem.repositories.PaymentRepository;

@Service
@Transactional
public class PaymentServices {
   private PaymentRepository paymentRepository;

    public PaymentServices(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment insertOnePayment(Payment payment){
        return paymentRepository.save(payment);
    }

    public Integer updatePayment(String pid,String action){
        return paymentRepository.updatePaymentByPid(pid, action);
    }

    public List<Payment> findPendingFinePayment(){
        return paymentRepository.getPendingFinePayments();
    }
    public List<Payment> findPendingRenewalPayment(){
        return paymentRepository.getPendingRenewalPayments();
    }

    public List<Payment> findPendingFinePaymentByUsername(String username){
        return paymentRepository.getPendingFinePaymentsByUsername(username);
    }
    public List<Payment> findPendingRenewalPaymentByUsername(String username){
        return paymentRepository.getPendingRenewalPaymentsByUsername(username);
    }

}
