package com.webproject.webprojectapi.controller;

import com.webproject.webprojectapi.jpql.AvgAetByDay;
import com.webproject.webprojectapi.jpql.AvgAetByMonth;
import com.webproject.webprojectapi.service.DataServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/data")
public class DataController {

    private final DataServiceImpl dataServiceImpl;

    @GetMapping("/month/avgaet")
    public List<AvgAetByMonth> getAvgAetMonth() {
        return dataServiceImpl.getAvgAetMonth();
    }

    @GetMapping("/day/avgaet")
    public List<AvgAetByDay> getAvgAetDay() {
        return dataServiceImpl.getAvgAetDay();
    }
}
