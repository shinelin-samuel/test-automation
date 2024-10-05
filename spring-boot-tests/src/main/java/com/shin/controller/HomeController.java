package com.shin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

    @RequestMapping(value = "get-profile", method = RequestMethod.GET)
    public ResponseEntity<String> getProfile() {
        return ResponseEntity.ok()
                .body("Hello World");
    }
}
