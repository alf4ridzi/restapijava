package com.lowcontext.restapijava.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping(path = "/")
    public String index() {
        return "ok";
    }
    
    @GetMapping(path = "/hello")
    public String hello() {
    	return "hello";
    }
    
}
