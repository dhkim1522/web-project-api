package com.webproject.webprojectapi.controller;

import com.webproject.webprojectapi.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class DataController {

    @GetMapping("/data")
    public String getData() {
        return "API Data 호출";
    }
}
