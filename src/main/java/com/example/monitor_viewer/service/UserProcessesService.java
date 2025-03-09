package com.example.monitor_viewer.service;

import com.example.monitor_viewer.model.UserProcesses;
import com.example.monitor_viewer.repository.UserProcessesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProcessesService {
    
    @Autowired
    private UserProcessesRepository userProcessesRepository;

    // Get all user processes
    public List<UserProcesses> getAllProcesses() {
        return userProcessesRepository.findAll();
    }

    // Get processes for a specific user
    public List<UserProcesses> getProcessesByUser(String user) {
        return userProcessesRepository.findByUser(user);
    }

    // Save a new process entry
    public UserProcesses saveUserProcess(UserProcesses process) {
        return userProcessesRepository.save(process);
    }

    // Delete all processes for a specific user before inserting new ones
    public void clearAndSaveUserProcesses(String user, List<String> processes) {
        userProcessesRepository.deleteByUser(user); // Clear existing processes

        for (String processName : processes) {
            UserProcesses newProcess = new UserProcesses(user, processName);
            userProcessesRepository.save(newProcess);
        }
    }
}
