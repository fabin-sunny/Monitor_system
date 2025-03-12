package com.example.monitor_viewer.dto;

import java.util.List;

public class ProcessRequestDTO {
    private String user;
    private List<ProcessDTO> processes;

    // Getters and Setters
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<ProcessDTO> getProcesses() {
        return processes;
    }

    public void setProcesses(List<ProcessDTO> processes) {
        this.processes = processes;
    }
}
