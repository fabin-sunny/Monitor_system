package com.example.monitor_viewer.controller;

import com.example.monitor_viewer.dto.ProcessRequestDTO;
import com.example.monitor_viewer.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/processes")
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @PostMapping("/update")
public ResponseEntity<String> updateProcesses(@RequestBody ProcessRequestDTO request) {
    //System.out.println("Received processes from user: " + request.getUser());

    processService.saveProcesses(request.getUser(), request.getProcesses());

    return ResponseEntity.ok("Process data updated successfully");
}

}
