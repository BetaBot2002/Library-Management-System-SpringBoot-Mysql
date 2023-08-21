package com.lms.librarymanagementsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.librarymanagementsystem.models.Users;

public interface UsersRepository extends JpaRepository<Users,String>{

    @Query(value="SELECT * FROM USERS WHERE USERNAME=:USERNAME AND PASSWORD=:PASSWORD", nativeQuery=true)
    public List<Users> getUserByUsernamePassword(@Param("USERNAME")String username,@Param("PASSWORD")String password);

    @Query(value="SELECT * FROM USERS WHERE USERNAME=:USERNAME", nativeQuery=true)
    public Users getUserByUsername(@Param("USERNAME")String username);

    @Query(value="SELECT MEMBERSHIPEXPIRE FROM USERS WHERE USERNAME=:USERNAME", nativeQuery=true)
    public String getExpireByUsername(@Param("USERNAME")String username);

    @Query(value="SELECT MEMBERSHIP FROM USERS WHERE USERNAME=:USERNAME", nativeQuery=true)
    public String getMembershipByUsername(@Param("USERNAME")String username);

    @Modifying
    @Query(value="UPDATE USERS SET MEMBERSHIP='inactive' WHERE MEMBERSHIPEXPIRE < CURDATE() AND MEMBERSHIP='active'", nativeQuery=true)
    Integer updateMembership();

    @Modifying
    @Query(value="UPDATE USERS SET MEMBERSHIP='active', MEMBERSHIPEXPIRE=:expire WHERE USERNAME=:username", nativeQuery=true)
    Integer updateMembershipActive(@Param("expire")String expire,@Param("username")String username);

    @Query(value="SELECT * FROM USERS WHERE USERNAME=:USERNAME AND MEMBERSHIP='inactive'", nativeQuery=true)
    List<Users> getInactiveUsers(@Param("USERNAME")String username);

    @Query(value="SELECT EMAIL FROM USERS WHERE USERNAME=:username",nativeQuery =true)
    String getMailByUsername(@Param("username")String username);

    @Modifying
    @Query(value = "UPDATE USERS SET PASSWORD=:password WHERE USERNAME=:username", nativeQuery = true)
    public Integer changePasswordByUsername(@Param("username")String username, @Param("password")String password);
    
}
