package com.webproject.webprojectapi.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
/**
 *   JWT Token 을 담은 User 객체를 반환하기 위한 VO
 */
public class DelayRateVO {

    private String getCarrierDelayRate;
    private String getWeatherDelayRate;
    private String getNasDelayRate;
    private String getSecurityDelayRate;
    private String getLateAircraftDelayRate;
}