package com.lms.librarymanagementsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.librarymanagementsystem.models.SoftCopy;

public interface SoftCopyRepository extends JpaRepository<SoftCopy,Integer>{
    @Query(value="SELECT * FROM SOFTCOPY WHERE TITLE LIKE %:PARAM% OR OWNER LIKE %:PARAM% OR PUBLISHER LIKE %:PARAM% OR DESCRIPTION LIKE %:PARAM% OR CATEGORY LIKE %:PARAM% OR KEYWORDS LIKE %:PARAM%",nativeQuery = true)
    public List<SoftCopy> findSoftCopyBySearch(@Param("PARAM")String searchParam);
    
    @Query(value="SELECT * FROM SOFTCOPY WHERE OWNER LIKE %:PARAM%",nativeQuery = true)
    public List<SoftCopy> findSoftCopyBySearchOwner(@Param("PARAM")String searchParam);

    @Query(value="SELECT * FROM SOFTCOPY WHERE PUBLISHER LIKE %:PARAM%",nativeQuery = true)
    List<SoftCopy> findSoftCopyBySearchPublisher(@Param("PARAM")String searchParam);

    @Query(value="SELECT * FROM SOFTCOPY WHERE CATEGORY LIKE %:PARAM%",nativeQuery = true)
    List<SoftCopy> findSoftCopyBySearchCatagory(@Param("PARAM")String searchParam);

    @Query(value="SELECT * FROM SOFTCOPY WHERE SID=:SID",nativeQuery = true)
    SoftCopy findSingleSoftCopyById(@Param("SID")String sid);

    @Query(value="SELECT * FROM SOFTCOPY WHERE TITLE LIKE %:PARAM%",nativeQuery = true)
    List<SoftCopy> findSoftCopyBySearchTitle(@Param("PARAM")String searchParam);

    @Query(value="SELECT * FROM SOFTCOPY WHERE KEYWORDS LIKE %:PARAM%",nativeQuery = true)
    List<SoftCopy> findSoftCopyBySearchKeywords(@Param("PARAM")String searchParam);

    @Query(value = "SELECT S.* FROM SOFTCOPY S,ALTERNATIVE A,CONNECTOR C WHERE S.SID=A.SID AND A.ITID=C.ITID AND A.ITID=:ITID",nativeQuery = true)
    List<SoftCopy> findAlternativeSoftCopy(@Param("ITID")String ITID);
    
    @Query(value="SELECT * FROM SOFTCOPY ORDER BY sid DESC LIMIT 2",nativeQuery = true)
    List<SoftCopy> getLastTwoSoftCopies();

    @Query(value="SELECT TITLE FROM SOFTCOPY WHERE SID=:sid",nativeQuery = true)
    String getTitleBySid(@Param("sid")String sid);

    @Query(value="SELECT THUMBNAIL FROM SOFTCOPY WHERE SID=:sid",nativeQuery = true)
    String getThumbnailBySid(@Param("sid")String sid);

    @Query(value="SELECT FILENAME FROM SOFTCOPY WHERE SID=:sid",nativeQuery = true)
    String getFileBySid(@Param("sid")String sid);

    @Modifying
    @Query(value="DELETE FROM SOFTCOPY WHERE SID=:sid",nativeQuery = true)
    Integer deleteSoftcopyBySid(@Param("sid")String sid);

    @Query(value="SELECT SID FROM SOFTCOPY ORDER BY SID DESC LIMIT 1",nativeQuery = true)
    String getLatestSID();

    
}
