package com.lms.librarymanagementsystem.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lms.librarymanagementsystem.models.Borrow;
import com.lms.librarymanagementsystem.repositories.BorrowRepository;


@Service
@Transactional
public class BorrowServices {
    private BorrowRepository borrowRepository;

    public BorrowServices(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    public Borrow inserOneBorrow(Borrow borrow){
        return borrowRepository.save(borrow);
    }

    public List<Borrow> findPendingBorrows(){
        return borrowRepository.getPendingBorrow();
    }

    public List<Borrow> findPendingReturns(){
        return borrowRepository.getPendingReturns();
    }

    public List<Borrow> findUnReturnedByUsername(String username){
        return borrowRepository.getUnReturnedByUsername(username);
    }

    public List<Borrow> findRequestedReturnByItidUsername(String itid,String username){
        return borrowRepository.getRequestedReturnByItidUsername(itid,username);
    }

    public List<Borrow> findUnReturnedByItidByUsername(String itid,String username){
        System.out.println(itid);
        return borrowRepository.getUnReturnedByItidByUsername(itid,username);
    }

    public List<Borrow> findReturnRejectedByItidByUsername(String itid,String username){
        System.out.println(itid);
        return borrowRepository.getReturnRejectedByItidByUsername(itid,username);
    }

    public List<Borrow> findApprovedUnReturnedByItidUsername(String itid,String username){
        System.out.println(itid);
        return borrowRepository.getApprovedUnReturnedByItidUsername(itid,username);
    }

    public List<Borrow> findFinableBorrowByUsername(String username){
        return borrowRepository.getFinableBorrowByUsername(username);
    }

    public Integer performAction(String action,String username,String itid){
        return borrowRepository.borrowAction(action, username, itid);
    }

    public Integer performReturnAction(String action,String username,String itid){
        return borrowRepository.returnAction(action, username, itid);
    }

    public Integer performReturn(String username,String itid){
        return borrowRepository.returnRequest(username, itid);
    }

    public List<Borrow> findNotReturnedRequestedListByUsername(String username){
        return borrowRepository.getNotReturnedRequestedListByUsername(username);
    }

    public List<Borrow> findReturnedOrRejectedListByUsername(String username){
        return borrowRepository.getReturnedOrRejectedListByUsername(username);
    }

    public List<Borrow> findFinedRequestedReturn(String username){
        return borrowRepository.getFinedReturnRequestedByUsername(username);
    }
}
