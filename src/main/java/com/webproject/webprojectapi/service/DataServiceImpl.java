package com.webproject.webprojectapi.service;

import com.webproject.webprojectapi.jpql.AvgAetByDay;
import com.webproject.webprojectapi.jpql.AvgAetByMonth;
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
    public List<AvgAetByMonth> getAvgAetMonth() {
        return dataRepository.findAvgAetByMonth();
    }

    @Override
    public List<AvgAetByDay> getAvgAetDay() {
        return dataRepository.findAvgAetByDay();
    }
}
