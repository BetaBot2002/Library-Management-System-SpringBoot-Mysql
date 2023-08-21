package com.lms.librarymanagementsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.librarymanagementsystem.models.*;

public interface MagazinesRepository extends JpaRepository<Magazines,Integer>{
    @Query(value="SELECT * FROM MAGAZINES WHERE TITLE LIKE %:PARAM% OR PUBLISHER LIKE %:PARAM% OR DESCRIPTION LIKE %:PARAM% OR CATEGORY LIKE %:PARAM% OR KEYWORDS LIKE %:PARAM%",nativeQuery = true)
    List<Magazines> findMagazineBySearch(@Param("PARAM") String searchParam);

    @Query(value="SELECT * FROM MAGAZINES WHERE PUBLISHER LIKE %:PARAM%",nativeQuery = true)
    List<Magazines> findMagazineBySearchPublisher(@Param("PARAM")String searchParam);

    @Query(value="SELECT * FROM MAGAZINES WHERE CATEGORY LIKE %:PARAM%",nativeQuery = true)
    List<Magazines> findMagazineBySearchCatagory(@Param("PARAM")String searchParam);

    @Query(value="SELECT * FROM MAGAZINES WHERE TITLE LIKE %:PARAM%",nativeQuery = true)
    List<Magazines> findMagazineBySearchTitle(@Param("PARAM")String searchParam);

    @Query(value="SELECT * FROM MAGAZINES WHERE KEYWORDS LIKE %:PARAM%",nativeQuery = true)
    List<Magazines> findMagazineBySearchKeywords(@Param("PARAM")String searchParam);

    @Query(value="SELECT * FROM MAGAZINES WHERE MID=:MID",nativeQuery = true)
    Magazines findSingleMagazineById(@Param("MID")String mid);

    @Modifying
    @Query(value="UPDATE MAGAZINES SET STOCK=STOCK-1 WHERE ITID=:ITID",nativeQuery = true)
    Integer decreaseStock(@Param("ITID")String ITID);
    
    @Modifying
    @Query(value="UPDATE MAGAZINES SET STOCK=STOCK+1 WHERE ITID=:ITID",nativeQuery = true)
    Integer increaseStock(@Param("ITID")String ITID);

    @Query(value="SELECT * FROM MAGAZINES ORDER BY mid DESC LIMIT 2",nativeQuery = true)
    List<Magazines> getLastTwoMagazines();

    @Query(value="SELECT * FROM MAGAZINES WHERE ITID=:itid",nativeQuery = true)
    Magazines getOneMagazineByItid(@Param("itid")String itid);

    
    @Query(value="SELECT TITLE FROM MAGAZINES WHERE ITID=:itid",nativeQuery = true)
    String getTitleByItid(@Param("itid")String itid);
    
    @Query(value="SELECT THUMBNAIL FROM MAGAZINES WHERE ITID=:itid",nativeQuery = true)
    String getThumbnailByItid(@Param("itid")String itid);
}
