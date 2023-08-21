package com.lms.librarymanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.librarymanagementsystem.models.Connector;

public interface ConnectorRepository extends JpaRepository<Connector,String>{
    @Query(value="SELECT TYPE FROM CONNECTOR WHERE ITID=:ITID",nativeQuery = true)
    String getType(@Param("ITID")String ITID);

    @Query(value="SELECT * FROM CONNECTOR WHERE ITID=:ITID",nativeQuery = true)
    Connector getConnectorByItid(@Param("ITID")String ITID);

    @Modifying
    @Query(value = "DELETE FROM CONNECTOR WHERE ITID=:itid", nativeQuery = true)
    Integer deleteSingleItemByItid(@Param("itid") String itid);

    @Query(value="SELECT ITID FROM Connector ORDER BY ITID DESC LIMIT 1",nativeQuery = true)
    String getLatestItid();
}
