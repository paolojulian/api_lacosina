package com.lacosina.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AppController {

    @GetMapping
    public String index() {
        return "Test";
    }
}
