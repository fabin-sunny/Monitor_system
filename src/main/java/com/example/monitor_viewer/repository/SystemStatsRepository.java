package com.example.monitor_viewer.repository;

import com.example.monitor_viewer.model.SystemStats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemStatsRepository extends JpaRepository<SystemStats, Long> {
}
