package com.example.monitor_viewer.repository;

import com.example.monitor_viewer.model.UserProcesses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserProcessesRepository extends JpaRepository<UserProcesses, Long> {
    List<UserProcesses> findByUser(String user); // Fetch processes for a specific user

    void deleteByUser(String user); // Delete processes for a specific user
}
