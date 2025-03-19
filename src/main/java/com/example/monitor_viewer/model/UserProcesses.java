package com.example.monitor_viewer.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_processes") // Maps to the MySQL table
public class UserProcesses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "user", nullable = false)
    private String user; // Stores the username

    @Column(name = "process_name", nullable = false)
    private String processName; // Stores the process name

    @Column(name = "cpu_usage", nullable = false)
    private double cpuUsage; // Stores CPU usage percentage

    @Column(name = "memory_usage", nullable = false)
    private double memoryUsage; // Stores memory usage in MB

    // Constructors
    public UserProcesses() {}
    
    

    public UserProcesses(String user, String processName, double cpuUsage, double memoryUsage) {
        this.user = user;
        this.processName = processName;
        this.cpuUsage = cpuUsage;
        this.memoryUsage = memoryUsage;
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
}
