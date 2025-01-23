package ust.com.cicss.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ust.com.cicss.services.TASService;

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