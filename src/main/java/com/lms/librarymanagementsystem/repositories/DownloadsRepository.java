package com.lms.librarymanagementsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.librarymanagementsystem.models.Downloads;

public interface DownloadsRepository extends JpaRepository<Downloads,Integer>{
    @Query(value="SELECT * FROM DOWNLOADS WHERE USERNAME=:username",nativeQuery = true)
    List<Downloads> getDownloadsByUsername(@Param("username")String username);

    @Query(value="SELECT SID FROM DOWNLOADS WHERE USERNAME=:username",nativeQuery = true)
    List<String> getSidByUsername(@Param("username")String username);
}
