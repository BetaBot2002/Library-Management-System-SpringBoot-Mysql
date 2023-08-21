package com.lms.librarymanagementsystem.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lms.librarymanagementsystem.models.Connector;
import com.lms.librarymanagementsystem.repositories.ConnectorRepository;

@Service
@Transactional
public class ConnectorServices {
    private ConnectorRepository connectorRepository;

    public ConnectorServices(ConnectorRepository connectorRepository) {
        this.connectorRepository = connectorRepository;
    }

    public Connector insertOneConnector(Connector connector){
        return connectorRepository.save(connector);
    }

    public String getType(String ITID){
        return connectorRepository.getType(ITID);
    }

    public Connector getConnectorByItid(String ITID){
        return connectorRepository.getConnectorByItid(ITID);
    }

    public Integer deleteSingleItemByItid(String itid){
        return connectorRepository.deleteSingleItemByItid(itid);
    }

    public String getLatestItid(){
        return connectorRepository.getLatestItid();
    }
}
