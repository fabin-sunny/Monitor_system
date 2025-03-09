package com.example.monitor_viewer.repository;

import com.example.monitor_viewer.model.StoreStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreStatsRepository extends JpaRepository<StoreStats, Long> {
    Optional<StoreStats> findByUser(String user);
}
