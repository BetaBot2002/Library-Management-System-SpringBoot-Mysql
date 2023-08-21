package com.lms.librarymanagementsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.librarymanagementsystem.models.SoftCopyDonations;

public interface SoftCopyDonationRepository extends JpaRepository<SoftCopyDonations, Integer> {
    @Query(value="SELECT * FROM SOFTCOPYDONATIONS WHERE APPROVED='pending'",nativeQuery = true)
    List<SoftCopyDonations> getPendingSoftCopyDonations();

    @Query(value = "SELECT * FROM SOFTCOPYDONATIONS WHERE SDNID=:PARAM", nativeQuery = true)
    SoftCopyDonations getSingleSoftCopyDonation(@Param("PARAM")Integer sdnid);

    @Modifying
    @Query(value = "UPDATE SOFTCOPYDONATIONS SET APPROVED='approved' WHERE SDNID=:PARAM", nativeQuery = true)
    Integer updateDonationApproval(@Param("PARAM")Integer sdnid);

    @Modifying
    @Query(value = "UPDATE SOFTCOPYDONATIONS SET APPROVED='rejected' WHERE SDNID=:PARAM", nativeQuery = true)
    Integer updateDonationRejection(@Param("PARAM")Integer sdnid);
}
