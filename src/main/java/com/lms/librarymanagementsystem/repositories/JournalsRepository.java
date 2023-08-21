package com.lms.librarymanagementsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.librarymanagementsystem.models.Journals;

public interface JournalsRepository extends JpaRepository<Journals,Integer> {
    @Query(value="SELECT * FROM JOURNALS WHERE TITLE LIKE %:PARAM% OR EDITOR LIKE %:PARAM% OR PUBLISHER LIKE %:PARAM% OR DESCRIPTION LIKE %:PARAM% OR CATEGORY LIKE %:PARAM% OR KEYWORDS LIKE %:PARAM%",nativeQuery = true)
    List<Journals> findJournalBySearch(@Param("PARAM")String searchParam);

    @Query(value="SELECT * FROM JOURNALS WHERE EDITOR LIKE %:PARAM%",nativeQuery = true)
    List<Journals> findJournalBySearchEditor(@Param("PARAM")String searchParam);

    @Query(value="SELECT * FROM JOURNALS WHERE PUBLISHER LIKE %:PARAM%",nativeQuery = true)
    List<Journals> findJournalBySearchPublisher(@Param("PARAM")String searchParam);

    @Query(value="SELECT * FROM JOURNALS WHERE CATEGORY LIKE %:PARAM%",nativeQuery = true)
    List<Journals> findJournalBySearchCatagory(@Param("PARAM")String searchParam);

    @Query(value="SELECT * FROM JOURNALS WHERE JID=:JID",nativeQuery = true)
    Journals findSingleJournalById(@Param("JID")String jid);

    @Query(value="SELECT * FROM JOURNALS WHERE TITLE LIKE %:PARAM%",nativeQuery = true)
    List<Journals> findJournalBySearchTitle(@Param("PARAM")String searchParam);

    @Query(value="SELECT * FROM JOURNALS WHERE KEYWORDS LIKE %:PARAM%",nativeQuery = true)
    List<Journals> findJournalBySearchKeywords(@Param("PARAM")String searchParam);

    @Modifying
    @Query(value="UPDATE JOURNALS SET STOCK=STOCK-1 WHERE ITID=:ITID",nativeQuery = true)
    Integer decreaseStock(@Param("ITID")String ITID);
    
    @Modifying
    @Query(value="UPDATE JOURNALS SET STOCK=STOCK+1 WHERE ITID=:ITID",nativeQuery = true)
    Integer increaseStock(@Param("ITID")String ITID);

    @Query(value="SELECT * FROM JOURNALS ORDER BY jid DESC LIMIT 2",nativeQuery = true)
    List<Journals> getLastTwoJournals();

    @Query(value="SELECT * FROM JOURNALS WHERE ITID=:itid",nativeQuery = true)
    Journals getOneJournalByItid(@Param("itid")String itid);

    
    @Query(value="SELECT TITLE FROM JOURNALS WHERE ITID=:itid",nativeQuery = true)
    String getTitleByItid(@Param("itid")String itid);

    @Query(value="SELECT THUMBNAIL FROM JOURNALS WHERE ITID=:itid",nativeQuery = true)
    String getThumbnailByItid(@Param("itid")String itid);
}
