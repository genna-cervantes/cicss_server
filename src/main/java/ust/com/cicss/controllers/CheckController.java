package ust.com.cicss.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {

    @GetMapping("/api/health")
    public String healthCheck() {
        return "Server is running!";
    }
}
