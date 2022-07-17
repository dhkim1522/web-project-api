package com.webproject.webprojectapi.service;

import com.webproject.webprojectapi.jpql.AvgAetByDay;
import com.webproject.webprojectapi.jpql.AvgAetByMonth;

import java.util.List;

public interface DataService {

    List<AvgAetByMonth> getAvgAetMonth();

    List<AvgAetByDay> getAvgAetDay();
}
