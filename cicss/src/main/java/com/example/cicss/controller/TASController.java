package com.example.cicss.controller;

import com.example.cicss.service.TASService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/tas")
@CrossOrigin("http://localhost:5173")
public class TASController {

    @Autowired
    private TASService tasService;

    @PostMapping("/authenticate")
    public HashMap<String, Object> authenticate(@RequestBody HashMap<String, String> rqBody) throws Exception{
        String email = rqBody.get("email");

        // db connection stuff
        boolean isAuth = tasService.authByEmail(email);

        HashMap<String, Object> response = new HashMap<>();
        response.put("auth", isAuth);
        return response;
    }

}
