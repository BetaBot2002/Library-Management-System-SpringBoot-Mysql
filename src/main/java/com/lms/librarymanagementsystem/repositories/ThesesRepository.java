package com.lms.librarymanagementsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.librarymanagementsystem.models.Theses;

public interface ThesesRepository extends JpaRepository<Theses,Integer>{
    @Query(value="SELECT * FROM THESES WHERE TITLE LIKE %:PARAM% OR RESEARCHER LIKE %:PARAM% OR GUIDES LIKE %:PARAM% OR DESCRIPTION LIKE %:PARAM% OR CATEGORY LIKE %:PARAM% OR KEYWORDS LIKE %:PARAM% OR PLACE LIKE %:PARAM% OR ABSTRACT LIKE %:PARAM%",nativeQuery = true)
    public List<Theses> findThesesBySearch(@Param("PARAM") String searchParam);

    @Query(value = "SELECT * FROM THESES WHERE RESEARCHER LIKE %:PARAM%",nativeQuery = true)
    public List<Theses> findThesesBySearchResearcher(@Param("PARAM")String searchParam);

    @Query(value="SELECT * FROM THESES WHERE CATEGORY LIKE %:PARAM%",nativeQuery = true)
    List<Theses> findThesesBySearchCatagory(@Param("PARAM")String searchParam);

    @Query(value="SELECT * FROM THESES WHERE TITLE LIKE %:PARAM%",nativeQuery = true)
    List<Theses> findThesesBySearchTitle(@Param("PARAM")String searchParam);

    @Query(value="SELECT * FROM THESES WHERE KEYWORDS LIKE %:PARAM%",nativeQuery = true)
    List<Theses> findThesesBySearchKeywords(@Param("PARAM")String searchParam);

    @Query(value="SELECT * FROM THESES WHERE TID=:TID",nativeQuery = true)
    Theses findSingleThesesById(@Param("TID")String mid);

    @Modifying
    @Query(value="UPDATE THESES SET STOCK=STOCK-1 WHERE ITID=:ITID",nativeQuery = true)
    Integer decreaseStock(@Param("ITID")String ITID);
    
    @Modifying
    @Query(value="UPDATE THESES SET STOCK=STOCK+1 WHERE ITID=:ITID",nativeQuery = true)
    Integer increaseStock(@Param("ITID")String ITID);

    @Query(value="SELECT * FROM THESES ORDER BY tid DESC LIMIT 2",nativeQuery = true)
    List<Theses> getLastTwoTheses();

    @Query(value="SELECT * FROM THESES WHERE ITID=:itid",nativeQuery = true)
    Theses getOneThesesByItid(@Param("itid")String itid);

    
    @Query(value="SELECT TITLE FROM THESES WHERE ITID=:itid",nativeQuery = true)
    String getTitleByItid(@Param("itid")String itid);

    @Query(value="SELECT THUMBNAIL FROM THESES WHERE ITID=:itid",nativeQuery = true)
    String getThumbnailByItid(@Param("itid")String itid);
}
