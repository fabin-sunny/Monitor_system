package com.example.monitor_viewer.controller;

import com.example.monitor_viewer.model.SystemStats;
import com.example.monitor_viewer.model.UserProcesses;
import com.example.monitor_viewer.service.SystemStatsService;
import com.example.monitor_viewer.service.UserProcessesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class SystemStatsRestController {

    @Autowired
    private SystemStatsService systemStatsService;

    @Autowired
    private UserProcessesService userProcessesService;

    // Endpoint to get system stats
    @GetMapping("/stats")
    public List<SystemStats> getStats() {
        return systemStatsService.getAllStats();
    }

    // Endpoint to get all user processes
    @GetMapping("/processes")
    public List<UserProcesses> getAllProcesses() {
        return userProcessesService.getAllProcesses();
    }

    // Endpoint to get processes for a specific user
    @GetMapping("/processes/{user}")
    public List<UserProcesses> getProcessesByUser(@PathVariable String user) {
        return userProcessesService.getProcessesByUser(user);
    }
}
