package com.lms.librarymanagementsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.librarymanagementsystem.models.JournalDonations;

public interface JournalDonationRepository extends JpaRepository<JournalDonations, Integer> {
    @Query(value="SELECT * FROM JOURNALDONATIONS WHERE APPROVED='pending'",nativeQuery = true)
    List<JournalDonations> getPendingJournalDonations();

    @Query(value = "SELECT * FROM JOURNALDONATIONS WHERE JDNID=:PARAM", nativeQuery = true)
    JournalDonations getSingleJournalDonation(@Param("PARAM")Integer jdnid);

    @Modifying
    @Query(value = "UPDATE JOURNALDONATIONS SET APPROVED='approved' WHERE JDNID=:PARAM", nativeQuery = true)
    Integer updateDonationApproval(@Param("PARAM")Integer jdnid);

    @Modifying
    @Query(value = "UPDATE JOURNALDONATIONS SET APPROVED='rejected' WHERE JDNID=:PARAM", nativeQuery = true)
    Integer updateDonationRejection(@Param("PARAM")Integer jdnid);
}