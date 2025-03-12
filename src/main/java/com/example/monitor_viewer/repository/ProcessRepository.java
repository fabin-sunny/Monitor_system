package com.example.monitor_viewer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.monitor_viewer.model.ProcessEntity;

@Repository
public interface ProcessRepository extends JpaRepository<ProcessEntity, Long> {

    List<ProcessEntity> findByUser(String user);
    Optional<ProcessEntity> findByUserAndProcessName(String user, String processName);
}
