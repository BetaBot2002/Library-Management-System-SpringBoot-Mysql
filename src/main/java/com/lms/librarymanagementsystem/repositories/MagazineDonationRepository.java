package com.lms.librarymanagementsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.librarymanagementsystem.models.MagazineDonations;

public interface MagazineDonationRepository extends JpaRepository<MagazineDonations, Integer> {
    @Query(value="SELECT * FROM MAGAZINEDONATIONS WHERE APPROVED='pending'",nativeQuery = true)
    List<MagazineDonations> getPendingMagazineDonations();

    @Query(value = "SELECT * FROM MAGAZINEDONATIONS WHERE MDNID=:PARAM", nativeQuery = true)
    MagazineDonations getSingleMagazineDonation(@Param("PARAM")Integer mdnid);

    @Modifying
    @Query(value = "UPDATE MAGAZINEDONATIONS SET APPROVED='approved' WHERE MDNID=:PARAM", nativeQuery = true)
    Integer updateDonationApproval(@Param("PARAM")Integer mdnid);

    @Modifying
    @Query(value = "UPDATE MAGAZINEDONATIONS SET APPROVED='rejected' WHERE MDNID=:PARAM", nativeQuery = true)
    Integer updateDonationRejection(@Param("PARAM")Integer mdnid);
}