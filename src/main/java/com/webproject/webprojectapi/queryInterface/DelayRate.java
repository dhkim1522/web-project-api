package com.webproject.webprojectapi.queryInterface;

public interface DelayRate {
    Double getCarrierDelayRate();
    Double getWeatherDelayRate();
    Double getNasDelayRate();
    Double getSecurityDelayRate();
    Double getLateAircraftDelayRate();
}
