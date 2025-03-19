package com.example.monitor_viewer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class InactiveSystemMonitorService {

    private static final Logger logger = LoggerFactory.getLogger(InactiveSystemMonitorService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Scheduled(fixedRate = 10000) // Runs every 10 seconds
    @Transactional
    public void markInactiveSystems() {
        String sql = "UPDATE system_stats SET status = 'inactive' WHERE last_updated < NOW() - INTERVAL 10 SECOND";
        int updatedRows = jdbcTemplate.update(sql);

        if (updatedRows > 0) {
            logger.info("Marked {} system(s) as inactive.", updatedRows);
        }
    }
}
