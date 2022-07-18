package com.webproject.webprojectapi.service;

import com.webproject.webprojectapi.queryInterface.*;
import com.webproject.webprojectapi.repository.DataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DataServiceImpl implements DataService {

    private final DataRepository dataRepository;

    @Override
    public List<AvgAetMonth> getAvgAetMonth() {
        return dataRepository.findAvgAetMonth();
    }

    @Override
    public List<AvgAetDay> getAvgAetDay(Integer month) {
        return dataRepository.findAvgAetDay(month);
    }

    @Override
    public List<AvgDepDelayMonth> getAvgDepDelayMonth() {
        return dataRepository.findAvgDepDelayMonth();
    }

    @Override
    public List<AvgDepDelayDay> getAvgDepDelayDay(Integer month) {
        return dataRepository.findAvgDepDelayDay(month);
    }

    @Override
    public List<DelayCount> getDelayCount() {
        return dataRepository.findDelayCount();
    }

    @Override
    public List<DelayRate> getDelayRate() {
        return dataRepository.findDelayRate();
    }


}
