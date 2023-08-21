package com.lms.librarymanagementsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.librarymanagementsystem.models.BookDonations;

public interface BookDonationRepository extends JpaRepository<BookDonations, Integer> {
    @Query(value="SELECT * FROM BOOKDONATIONS WHERE APPROVED='pending'",nativeQuery = true)
    List<BookDonations> getPendingBookDonations();

    @Query(value = "SELECT * FROM BOOKDONATIONS WHERE BDNID=:PARAM", nativeQuery = true)
    BookDonations getSingleBookDonation(@Param("PARAM")Integer bdnid);

    @Modifying
    @Query(value = "UPDATE BOOKDONATIONS SET APPROVED='approved' WHERE BDNID=:PARAM", nativeQuery = true)
    Integer updateDonationApproval(@Param("PARAM")Integer bdnid);

    @Modifying
    @Query(value = "UPDATE BOOKDONATIONS SET APPROVED='rejected' WHERE BDNID=:PARAM", nativeQuery = true)
    Integer updateDonationRejection(@Param("PARAM")Integer bdnid);
}
