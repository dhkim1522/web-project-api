package com.webproject.webprojectapi.controller;

import com.webproject.webprojectapi.queryInterface.*;
import com.webproject.webprojectapi.service.DataServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/data")
public class DataController {

    private final DataServiceImpl dataServiceImpl;

    @GetMapping("/month/avgaet")
    public List<AvgAetMonth> getAvgAetMonth() {
        return dataServiceImpl.getAvgAetMonth();
    }


//    @PostMapping("/login")
//    public UserVO login(@RequestBody UserLoginDTO userLoginDTO) {
//
//        log.info("login token 발급 " + userServiceImpl.login(userLoginDTO).toString());
//
//        return userServiceImpl.login(userLoginDTO);
//    }

    @GetMapping("/day/avgaet/{month}")
    public List<AvgAetDay> getAvgAetDay(@PathVariable("month") Integer month) {
        return dataServiceImpl.getAvgAetDay(month);
    }

    @GetMapping("/month/avg-dep-delay")
    public List<AvgDepDelayMonth> getAvgDepDelayMonth() {
        return dataServiceImpl.getAvgDepDelayMonth();
    }

    @GetMapping("/day/avg-dep-delay/{month}")
    public List<AvgDepDelayDay> getAvgDepDelayDay(@PathVariable("month") Integer month) {
        return dataServiceImpl.getAvgDepDelayDay(month);
    }

    @GetMapping("/delay-count")
    public List<DelayCount> getDelayCount() {
        return dataServiceImpl.getDelayCount();
    }

    @GetMapping("/delay-rate")
    public List<DelayRate> getDelayRate() {
        return dataServiceImpl.getDelayRate();
    }
}
