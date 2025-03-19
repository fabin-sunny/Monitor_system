package com.example.monitor_viewer.model;

import jakarta.persistence.*;

@Entity
@Table(name = "system_stats") // This maps to your MySQL table
public class SystemStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremented primary key
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "user", nullable = false)
    private String user; 

    @Column(name = "ip_address", nullable = false)
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

    @Column(name = "status") 
    private String status;

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

    public String getStatus() { return status; } 
    public void setStatus(String status) { this.status = status; }
}
