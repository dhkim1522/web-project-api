package com.webproject.webprojectapi.queryInterface;

public interface DelayCount {
    Integer getCarrierDelayCount();
    Integer getWeatherDelayCount();
    Integer getNasDelayCount();
    Integer getSecurityDelayCount();
    Integer getLateAircraftDelayCount();
}
