package com.example.monitor_viewer.controller;

import com.example.monitor_viewer.model.SystemStats;
import com.example.monitor_viewer.service.SystemStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class SystemStatsRestController {

    @Autowired
    private SystemStatsService systemStatsService;

    @GetMapping("/stats")
    public List<SystemStats> getStats() {
        return systemStatsService.getAllStats(); // Returns the latest data as JSON
    }
}
