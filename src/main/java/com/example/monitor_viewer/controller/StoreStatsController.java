package com.example.monitor_viewer.controller;

import com.example.monitor_viewer.dto.SystemStatsDTO;
import com.example.monitor_viewer.service.StoreStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/system-stats")
public class StoreStatsController {

    @Autowired
    private StoreStatsService systemStatsService;

    @PostMapping("/update")
    public String updateSystemStats(@RequestBody SystemStatsDTO systemStatsDTO) {
        systemStatsService.saveSystemStats(systemStatsDTO);
        return "System stats updated successfully";
    }
}
