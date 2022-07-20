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

    // TODO: API 요청 시 마다 JWT Token 인가 처리 구현 해야함 (Data)
    private final DataServiceImpl dataServiceImpl;

    // 월별 평균 운항 시간
    @GetMapping("/month/avgaet")
    public List<AvgAetMonth> getAvgAetMonth() {
        return dataServiceImpl.getAvgAetMonth();
    }

    // 일별 평균 운항 시간
    @GetMapping("/day/avgaet/{month}")
    public List<AvgAetDay> getAvgAetDay(@PathVariable("month") Integer month) {
        return dataServiceImpl.getAvgAetDay(month);
    }

    // 월별 평균 출발 지연 시간
    @GetMapping("/month/avg-dep-delay")
    public List<AvgDepDelayMonth> getAvgDepDelayMonth() {
        return dataServiceImpl.getAvgDepDelayMonth();
    }

    // 일별 평균 출발 지연 시간
    @GetMapping("/day/avg-dep-delay/{month}")
    public List<AvgDepDelayDay> getAvgDepDelayDay(@PathVariable("month") Integer month) {
        return dataServiceImpl.getAvgDepDelayDay(month);
    }

    // 운항 지연 사유 별 건수
    @GetMapping("/delay-count")
    public List<DelayCount> getDelayCount() {
        return dataServiceImpl.getDelayCount();
    }

    // 운항 지연 사유 별 분포
    @GetMapping("/delay-rate")
    public List<DelayRate> getDelayRate() {
        return dataServiceImpl.getDelayRate();
    }

    // 전체 운항 취소 및 우회 건 수
    @GetMapping("/cancel-divert")
    public List<CancelDivertCount> getCancelDivertCount() {
        return dataServiceImpl.getCancelDivertCount();
    }

    // 전체 운항 취소 사유 별 분포
    @GetMapping("/cancel-code")
    public List<CancelCodeCount> getCancelCodeCount() {
        return dataServiceImpl.getCancelCodeCount();
    }

    // 전체 데이터셋 총 개수
    @GetMapping("/count")
    public Long getCountAll() {
        return dataServiceImpl.getCountAll();
    }
}
