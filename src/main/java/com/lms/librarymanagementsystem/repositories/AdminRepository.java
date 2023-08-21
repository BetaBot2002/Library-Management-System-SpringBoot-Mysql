package com.lms.librarymanagementsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.librarymanagementsystem.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
    @Query(value="SELECT * FROM ADMIN WHERE USERNAME=:USERNAME AND PASSWORD=:PASSWORD", nativeQuery=true)
    public List<Admin> getUserByUsernamePassword(@Param("USERNAME")String username,@Param("PASSWORD")String password);

    @Modifying
    @Query(value = "UPDATE ADMIN SET PASSWORD=:password WHERE USERNAME=:username", nativeQuery = true)
    public Integer changePasswordByUsername(@Param("username")String username, @Param("password")String password);
}
