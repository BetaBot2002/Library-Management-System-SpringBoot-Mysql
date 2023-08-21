package com.lms.librarymanagementsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.librarymanagementsystem.models.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow,Integer> {

    @Query(value="SELECT * FROM BORROW WHERE APPROVED='pending'",nativeQuery = true)
    List<Borrow> getPendingBorrow();

    @Query(value="SELECT * FROM BORROW WHERE STATUS='requested'",nativeQuery = true)
    List<Borrow> getPendingReturns();

    @Query(value="SELECT * FROM BORROW WHERE USERNAME=:username AND STATUS='notreturned' AND APPROVED!='rejected'",nativeQuery = true)
    List<Borrow> getUnReturnedByUsername(@Param("username")String username);

    @Query(value="SELECT * FROM BORROW WHERE USERNAME=:username AND ITID=:itid AND STATUS='notreturned' AND APPROVED='approved'",nativeQuery = true)
    List<Borrow> getApprovedUnReturnedByItidUsername(@Param("itid")String itid,@Param("username")String username);

    @Query(value="SELECT * FROM BORROW WHERE USERNAME=:username AND ITID=:itid AND STATUS='requested' AND APPROVED!='rejected'",nativeQuery = true)
    List<Borrow> getRequestedReturnByItidUsername(@Param("itid")String itid,@Param("username")String username);
    
    @Query(value="SELECT * FROM BORROW WHERE USERNAME=:username AND ITID=:itid AND STATUS='notreturned' AND APPROVED!='rejected'",nativeQuery = true)
    List<Borrow> getUnReturnedByItidByUsername(@Param("itid")String itid,@Param("username")String username);

    @Query(value="SELECT * FROM BORROW WHERE USERNAME=:username AND ITID=:itid AND STATUS='return rejected' AND APPROVED!='rejected'",nativeQuery = true)
    List<Borrow> getReturnRejectedByItidByUsername(@Param("itid")String itid,@Param("username")String username);

    @Query(value="SELECT * FROM BORROW WHERE USERNAME=:username AND RETURNDATE < CURDATE() AND STATUS='notreturned' AND APPROVED='approved'",nativeQuery = true)
    List<Borrow> getFinableBorrowByUsername(@Param("username")String username);

    @Modifying
    @Query(value="UPDATE BORROW SET APPROVED=:action WHERE USERNAME=:username AND ITID=:itid AND APPROVED!='rejected'",nativeQuery = true)
    Integer borrowAction(@Param("action")String action,@Param("username")String username,@Param("itid")String itid);

    @Modifying
    @Query(value="UPDATE BORROW SET STATUS='requested' WHERE USERNAME=:username AND ITID=:itid AND STATUS IN ('notreturned','return rejected')",nativeQuery = true)
    Integer returnRequest(@Param("username")String username,@Param("itid")String itid);

    @Modifying
    @Query(value="UPDATE BORROW SET STATUS=:action WHERE USERNAME=:username AND ITID=:itid AND STATUS='requested'",nativeQuery = true)
    Integer returnAction(@Param("action")String action,@Param("username")String username,@Param("itid")String itid);

    @Query(value = "SELECT * FROM BORROW WHERE USERNAME=:username AND STATUS IN ('notreturned', 'requested', 'return rejected') AND APPROVED!='rejected'", nativeQuery = true)
    List<Borrow> getNotReturnedRequestedListByUsername(@Param("username")String username);

    @Query(value = "SELECT * FROM BORROW WHERE USERNAME=:username AND STATUS IN ('returned') AND APPROVED!='rejected'", nativeQuery = true)
    List<Borrow> getReturnedOrRejectedListByUsername(@Param("username")String username);

    @Query(value = "SELECT * FROM BORROW WHERE USERNAME=:username AND STATUS IN ('requested') AND RETURNDATE < CURDATE() AND APPROVED!='rejected'", nativeQuery = true)
    List<Borrow> getFinedReturnRequestedByUsername(@Param("username")String username);

}

