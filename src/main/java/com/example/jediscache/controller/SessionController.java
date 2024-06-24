package com.example.jediscache.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SessionController {
    @GetMapping("/")
    public Map<String, String> home(HttpSession session){
        Integer visitCount = (Integer) session.getAttribute("visits");
        if(visitCount == null)
            visitCount = 0;
        session.setAttribute("visits", ++visitCount);
        return Map.of("seesion id", session.getId(), "visitcount", visitCount.toString());
    }

}
