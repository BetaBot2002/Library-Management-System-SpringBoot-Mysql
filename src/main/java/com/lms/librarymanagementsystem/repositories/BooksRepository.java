package com.lms.librarymanagementsystem.repositories;

import java.util.List;

// import org.hibernate.mapping.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.librarymanagementsystem.models.Books;

public interface BooksRepository extends JpaRepository<Books, Integer> {
    @Query(value = "SELECT * FROM BOOKS WHERE TITLE LIKE %:PARAM% OR AUTHOR LIKE %:PARAM% OR PUBLISHER LIKE %:PARAM% OR DESCRIPTION LIKE %:PARAM% OR CATEGORY LIKE %:PARAM% OR KEYWORDS LIKE %:PARAM%", nativeQuery = true)
    List<Books> findBookBySearch(@Param("PARAM") String searchParam);

    @Query(value = "SELECT B.* FROM BOOKS B,CONNECTOR C WHERE B.ITID=C.ITID AND B.AUTHOR LIKE %:PARAM%", nativeQuery = true)
    List<Books> findBookBySearchAuthor(@Param("PARAM") String searchParam);

    @Query(value = "SELECT * from Books where BID=:PARAM", nativeQuery = true)
    Books getSingleBook(@Param("PARAM") String bookId);

    @Query(value = "SELECT * FROM BOOKS WHERE PUBLISHER LIKE %:PARAM%", nativeQuery = true)
    List<Books> findBookBySearchPublisher(@Param("PARAM") String searchParam);

    @Query(value = "SELECT * FROM BOOKS WHERE CATEGORY LIKE %:PARAM%", nativeQuery = true)
    List<Books> findBookBySearchCatagory(@Param("PARAM") String searchParam);

    @Query(value = "SELECT * FROM BOOKS WHERE TITLE LIKE %:PARAM%", nativeQuery = true)
    List<Books> findBookBySearchTitle(@Param("PARAM") String searchParam);

    @Query(value = "SELECT * FROM BOOKS WHERE KEYWORDS LIKE %:PARAM%", nativeQuery = true)
    List<Books> findBookBySearchKeywords(@Param("PARAM") String searchParam);

    @Modifying
    @Query(value = "UPDATE BOOKS SET STOCK=STOCK-1 WHERE ITID=:ITID", nativeQuery = true)
    Integer decreaseStock(@Param("ITID") String ITID);

    @Modifying
    @Query(value = "UPDATE BOOKS SET STOCK=STOCK+1 WHERE ITID=:ITID", nativeQuery = true)
    Integer increaseStock(@Param("ITID") String ITID);

    @Query(value = "SELECT * FROM BOOKS ORDER BY bid DESC LIMIT 2", nativeQuery = true)
    List<Books> getLastTwoBooks();

    @Query(value = "SELECT * FROM BOOKS WHERE ITID=:itid", nativeQuery = true)
    Books getOneBookByItid(@Param("itid") String itid);

    @Query(value = "SELECT TITLE FROM BOOKS WHERE ITID=:itid", nativeQuery = true)
    String getTitleByItid(@Param("itid") String itid);

    @Query(value="SELECT THUMBNAIL FROM BOOKS WHERE ITID=:itid",nativeQuery = true)
    String getThumbnailByItid(@Param("itid")String itid);

    // @Modifying
    // @Query(value = "DELETE FROM BOOKS WHERE ITID=:itid", nativeQuery = true)
    // Integer deleteSingleBookByBid(@Param("itid") Integer itid);
}
