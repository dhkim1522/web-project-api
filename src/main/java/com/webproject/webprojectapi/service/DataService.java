package com.webproject.webprojectapi.service;

import com.webproject.webprojectapi.entity.Data;
import com.webproject.webprojectapi.queryInterface.*;

import java.util.List;

public interface DataService {

    List<AvgAetMonth> getAvgAetMonth();
    List<AvgAetDay> getAvgAetDay(Integer month);
    List<AvgDepDelayMonth> getAvgDepDelayMonth();
    List<AvgDepDelayDay> getAvgDepDelayDay(Integer month);
    List<DelayCount> getDelayCount();
    List<DelayRate> getDelayRate();

    List<CancelDivertCount> getCancelDivertCount();

    List<CancelCodeCount> getCancelCodeCount();

    Long getCountAll();
}
