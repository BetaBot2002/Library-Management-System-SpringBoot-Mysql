package com.lms.librarymanagementsystem.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lms.librarymanagementsystem.models.Downloads;
import com.lms.librarymanagementsystem.repositories.DownloadsRepository;

@Service
@Transactional
public class DownloadsServices {
    private DownloadsRepository downloadsRepository;

    public DownloadsServices(DownloadsRepository downloadsRepository) {
        this.downloadsRepository = downloadsRepository;
    }

    public Downloads insertOneDownloads(Downloads download){
        return downloadsRepository.save(download);
    }

    public List<Downloads> findDownloadsByUsername(String username){
        return downloadsRepository.getDownloadsByUsername(username);
    }

    public List<String> findSidByUsername(String username){
        return downloadsRepository.getSidByUsername(username);
    }

}
