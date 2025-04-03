package ust.com.cicss.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ust.com.cicss.dao.DepartmentChairRepository;
import ust.com.cicss.dao.TASRepository;
import ust.com.cicss.models.DepartmentChairDetails;
import ust.com.cicss.models.TASDetails;
import ust.com.cicss.utils.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private DepartmentChairRepository dcRepository;

    @Autowired
    private TASRepository tasRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/try")
    public void tryNew() {
        System.out.println("tye");
    }

    @PostMapping("/verify-token")
    public ResponseEntity<?> verifyToken(@RequestBody Map<String, String> request) {
        
        System.out.println("verifying token");

        if (request == null || !request.containsKey("token") || request.get("token") == null || request.get("token").trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Token is required");
        }

        if (!request.containsKey("email") || request.get("email") == null || request.get("email").trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Email is required");
        }

        String token = request.get("token");
        String email = request.get("email");

        System.out.println(token);
        System.out.println(email);

        try {
            boolean validated = jwtUtil.validateToken(token, email);

            System.out.println(validated);

            if (!validated) {
                Map<String, String> response = new HashMap<>();
                response.put("message", "Authentication Error");
                response.put("details", "An unexpected error occurred");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }

            String role = jwtUtil.extractRole(token);
            Map<String, String> response = new HashMap<>();
            response.put("role", role);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            System.out.println("Unexpected error during authentication: " + e.getMessage());
            Map<String, String> response = new HashMap<>();
            response.put("message", "Authentication Error");
            response.put("details", "An unexpected error occurred");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody Map<String, String> request) {

        if (request == null || !request.containsKey("email") || request.get("email") == null || request.get("email").trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Email is required");
        }

        String email = request.get("email");

        try {
            DepartmentChairDetails departmentChair = dcRepository.getDepartmentChairByEmail(email);
            if (departmentChair != null) {
                String token = jwtUtil.generateToken(email, "Department_Chair");
                Map<String, String> response = new HashMap<>();
                response.put("token", token);
                response.put("email", email);
                response.put("role", "Department Chair");
                response.put("department", departmentChair.getDepartment());
                return ResponseEntity.ok(response);
            }

            TASDetails tas = tasRepository.getTasFromEmail(email);
            if (tas != null) {
                String token = jwtUtil.generateToken(email, "TAS");
                Map<String, String> response = new HashMap<>();
                response.put("token", token);
                response.put("email", email);
                response.put("role", "TAS");
                response.put("department", tas.getDepartment());
                return ResponseEntity.ok(response);
            }

            // Safe email parsing
            String college = null;
            try {
                String[] emailParts = email.split("@");
                if (emailParts.length > 0) {
                    String[] usernameParts = emailParts[0].split("\\.");
                    if (usernameParts.length > 0) {
                        college = usernameParts[usernameParts.length - 1];
                    }
                }
            } catch (Exception e) {
                System.out.println("Error parsing email: " + e.getMessage());
            }

            if ("cics".equals(college)) {
                String token = jwtUtil.generateToken(email, "Student");
                Map<String, String> response = new HashMap<>();
                response.put("token", token);
                response.put("role", "Student");
                return ResponseEntity.ok(response);
            }

            Map<String, String> response = new HashMap<>();
            response.put("message", "Authentication Failed");
            response.put("details", "Invalid Credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);

        } catch (Exception e) {
            System.out.println("Unexpected error during authentication: " + e.getMessage());
            Map<String, String> response = new HashMap<>();
            response.put("message", "Authentication Error");
            response.put("details", "An unexpected error occurred");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
