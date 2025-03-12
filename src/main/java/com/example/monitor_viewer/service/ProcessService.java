package com.example.monitor_viewer.service;

import com.example.monitor_viewer.dto.ProcessDTO;
import com.example.monitor_viewer.dto.ProcessRequestDTO;
import com.example.monitor_viewer.model.ProcessEntity;
import com.example.monitor_viewer.repository.ProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProcessService {

    @Autowired
    private ProcessRepository processRepository;

    public void saveProcesses(String user, List<ProcessDTO> processes) {
        // Get all existing processes for the user
        List<ProcessEntity> existingProcesses = processRepository.findByUser(user);

        // Convert new process names into a set for quick lookup
        List<String> newProcessNames = processes.stream()
            .map(ProcessDTO::getProcessName)
            .collect(Collectors.toList());

        // Delete processes that no longer exist in the new list
        for (ProcessEntity existingProcess : existingProcesses) {
            if (!newProcessNames.contains(existingProcess.getProcessName())) {
                processRepository.delete(existingProcess);
                System.out.println("Deleted terminated process: " + existingProcess.getProcessName());
            }
        }

        // Update or insert new processes
        for (ProcessDTO process : processes) {
            Optional<ProcessEntity> existingProcess = processRepository
                .findByUserAndProcessName(user, process.getProcessName());

            if (existingProcess.isPresent()) {
                // Update existing process usage values
                ProcessEntity processEntity = existingProcess.get();
                processEntity.setCpuUsage(process.getCpuUsage());
                processEntity.setMemoryUsage(process.getMemoryUsage());
                processRepository.save(processEntity);
            } else {
                // Insert new process if it doesn't exist
                ProcessEntity newProcess = new ProcessEntity(
                    user,
                    process.getProcessName(),
                    process.getCpuUsage(),
                    process.getMemoryUsage()
                );
                processRepository.save(newProcess);
            }
        }
    }
}
