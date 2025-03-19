package com.example.monitor_viewer.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_processes")
public class ProcessEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user", nullable = false)
    private String user;

    @Column(name = "process_name", nullable = false)
    private String processName;

    @Column(name = "cpu_usage")
    private double cpuUsage;

    @Column(name = "memory_usage")
    private double memoryUsage;

    @Column(name = "last_updated", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime lastUpdated = LocalDateTime.now();

    //Constructor with all parameters
    public ProcessEntity(String user, String processName, double cpuUsage, double memoryUsage) {
        this.user = user;
        this.processName = processName;
        this.cpuUsage = cpuUsage;
        this.memoryUsage = memoryUsage;
        this.lastUpdated = LocalDateTime.now();
    }

    // No-argument constructor
    public ProcessEntity() {
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public String getProcessName() { return processName; }
    public void setProcessName(String processName) { this.processName = processName; }

    public double getCpuUsage() { return cpuUsage; }
    public void setCpuUsage(double cpuUsage) { this.cpuUsage = cpuUsage; }

    public double getMemoryUsage() { return memoryUsage; }
    public void setMemoryUsage(double memoryUsage) { this.memoryUsage = memoryUsage; }

    public LocalDateTime getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(LocalDateTime lastUpdated) { this.lastUpdated = lastUpdated; }
}
