package com.eradev.boot_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

        @org.springframework.beans.factory.annotation.Value("${hello.message}")
        private String hello;

        @GetMapping("/")
        public String getMethodName() {
                return hello;
        }

}