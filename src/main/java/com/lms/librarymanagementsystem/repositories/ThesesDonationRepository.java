package com.lms.librarymanagementsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.librarymanagementsystem.models.ThesesDonations;

public interface ThesesDonationRepository extends JpaRepository<ThesesDonations, Integer> {
    @Query(value="SELECT * FROM THESESDONATIONS WHERE APPROVED='pending'",nativeQuery = true)
    List<ThesesDonations> getPendingThesesDonations();

    @Query(value = "SELECT * FROM THESESDONATIONS WHERE TDNID=:PARAM", nativeQuery = true)
    ThesesDonations getSingleThesesDonation(@Param("PARAM")Integer tdnid);

    @Modifying
    @Query(value = "UPDATE THESESDONATIONS SET APPROVED='approved' WHERE TDNID=:PARAM", nativeQuery = true)
    Integer updateDonationApproval(@Param("PARAM")Integer tdnid);

    @Modifying
    @Query(value = "UPDATE THESESDONATIONS SET APPROVED='rejected' WHERE TDNID=:PARAM", nativeQuery = true)
    Integer updateDonationRejection(@Param("PARAM")Integer tdnid);
}
// thesesdonation