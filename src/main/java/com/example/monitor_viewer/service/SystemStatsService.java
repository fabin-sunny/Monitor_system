package com.example.monitor_viewer.service;

import com.example.monitor_viewer.model.SystemStats;
import com.example.monitor_viewer.repository.SystemStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemStatsService {
    @Autowired
    private SystemStatsRepository systemStatsRepository;

    public List<SystemStats> getAllStats() {
        return systemStatsRepository.findAll();
    }
}
