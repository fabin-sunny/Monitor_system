package com.example.monitor_viewer.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "system_stats")
public class StoreStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user", unique = true, nullable = false)
    private String user;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "cpu_usage")
    private double cpuUsage;

    @Column(name = "memory_used")
    private double memoryUsed;

    @Column(name = "memory_total")
    private double memoryTotal;

    @Column(name = "disk_used")
    private double diskUsed;

    @Column(name = "disk_total")
    private double diskTotal;

    @Column(name = "last_updated", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime lastUpdated = LocalDateTime.now();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public double getCpuUsage() { return cpuUsage; }
    public void setCpuUsage(double cpuUsage) { this.cpuUsage = cpuUsage; }

    public double getMemoryUsed() { return memoryUsed; }
    public void setMemoryUsed(double memoryUsed) { this.memoryUsed = memoryUsed; }

    public double getMemoryTotal() { return memoryTotal; }
    public void setMemoryTotal(double memoryTotal) { this.memoryTotal = memoryTotal; }

    public double getDiskUsed() { return diskUsed; }
    public void setDiskUsed(double diskUsed) { this.diskUsed = diskUsed; }

    public double getDiskTotal() { return diskTotal; }
    public void setDiskTotal(double diskTotal) { this.diskTotal = diskTotal; }

    public LocalDateTime getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(LocalDateTime lastUpdated) { this.lastUpdated = lastUpdated; }
}
