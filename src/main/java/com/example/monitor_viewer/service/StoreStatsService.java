package com.example.monitor_viewer.service;

import com.example.monitor_viewer.dto.SystemStatsDTO;
import com.example.monitor_viewer.model.StoreStats;
import com.example.monitor_viewer.repository.StoreStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StoreStatsService {

    @Autowired
    private StoreStatsRepository systemStatsRepository;

    public void saveSystemStats(SystemStatsDTO systemStatsDTO) {
        StoreStats stats = systemStatsRepository.findByUser(systemStatsDTO.getUser())
                .orElse(new StoreStats());

        stats.setUser(systemStatsDTO.getUser());
        stats.setIpAddress(systemStatsDTO.getIpAddress());
        stats.setCpuUsage(systemStatsDTO.getCpuUsage());
        stats.setMemoryUsed(systemStatsDTO.getMemoryUsed());
        stats.setMemoryTotal(systemStatsDTO.getMemoryTotal());
        stats.setDiskUsed(systemStatsDTO.getDiskUsed());
        stats.setDiskTotal(systemStatsDTO.getDiskTotal());
        stats.setLastUpdated(LocalDateTime.now());

        systemStatsRepository.save(stats);
    }
}
