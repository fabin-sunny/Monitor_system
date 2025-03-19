package com.example.monitor_viewer.dto;

import java.time.LocalDateTime;

public class SystemStatsDTO {
    private String user;
    private String ipAddress;
    private double cpuUsage;
    private double memoryUsed;
    private double memoryTotal;
    private double diskUsed;
    private double diskTotal;
    private LocalDateTime lastUpdated; 
    private String status; 

    // Getters and Setters
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

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
