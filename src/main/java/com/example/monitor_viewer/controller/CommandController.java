package com.example.monitor_viewer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CommandController {

    private final Map<String, String> commandMap = new ConcurrentHashMap<>();
    private final Map<String, String> outputMap = new ConcurrentHashMap<>();
    private final Map<String, WebSocketSession> clientSessions = new ConcurrentHashMap<>();

    // Send command to a specific system
    @PostMapping("/command")
    public ResponseEntity<String> sendCommand(@RequestBody Map<String, String> request) {
        String system = request.get("system");
        String command = request.get("command");

        if (system == null || command == null || system.trim().isEmpty() || command.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("System and command must be provided.");
        }

        commandMap.put(system, command);
        System.out.println("Command received for system: " + system + " -> " + command);

        // If system is connected using WebSocket, send the command instantly
        WebSocketSession session = clientSessions.get(system);
        if (session != null && session.isOpen()) {
            try {
                session.sendMessage(new TextMessage(command));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return ResponseEntity.ok("Command sent to " + system);
    }

    // Fetch command for a specific system (for Java client)
    @GetMapping("/command")
    public ResponseEntity<String> getCommand(@RequestParam(name = "system") String system) {
        if (!commandMap.containsKey(system)) {
            return ResponseEntity.ok(""); // No command available
        }
        String commandToSend = commandMap.remove(system);
        System.out.println("Sending command: '" + commandToSend + "' to " + system);
        return ResponseEntity.ok(commandToSend);
    }

    //Receive command execution output from Java application
    @PostMapping("/command/output")
    public ResponseEntity<String> receiveCommandOutput(@RequestBody Map<String, String> request) {
        String system = request.get("system");
        String command = request.get("command");
        String output = request.get("output");

        if (system == null || command == null || output == null || system.trim().isEmpty() || command.trim().isEmpty() || output.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid request: system, command, and output must be provided.");
        }

        outputMap.put(system, output); // Clear old output & store the latest one
        System.out.println("Received output for system: " + system + "\nCommand: " + command + "\nOutput: " + output);

        // If WebSocket session exists, send output to client instantly
        WebSocketSession session = clientSessions.get(system);
        if (session != null && session.isOpen()) {
            try {
                session.sendMessage(new TextMessage(output));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return ResponseEntity.ok("Output received for system: " + system);
    }

    //Get command output for a specific system
    @GetMapping("/command/output")
    public ResponseEntity<String> getCommandOutput(@RequestParam(name = "system") String system) {
        String output = outputMap.getOrDefault(system, "No output available");
        return ResponseEntity.ok(output);
    }

    //Register WebSocket clients
    public void registerClient(String system, WebSocketSession session) {
        clientSessions.put(system, session);
    }

    //Remove WebSocket clients on disconnect
    public void removeClient(String system) {
        clientSessions.remove(system);
    }
}
