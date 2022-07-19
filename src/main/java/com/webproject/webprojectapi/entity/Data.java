package com.webproject.webprojectapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
/**
 *   차트를 위한 데이터셋 엔티티
 *   @Author dhkim1522(김동현)
 */
public class Data {

    /**
     *   Airline Data Field Description
     *
     *   1. ROW_ID : ROW 구분을 위한 PK
     *   2. D_YEAR : 년
     *   3. D_MONTH : 월
     *   4. DAY_OF_MONTH : 일
     *   5. DAY_OF_WEEK : 주
     *   6. DEP_TIME : 실제 출발 시간
     *   7. CRS_DEP_TIME : 출발 예정 시간
     *   8. ARR_TIME : 실제 도착 시간
     *   9. CRS_ARR_TIME : 도착 예정 시간
     *   10. UNIQUE_CARRIER : 캐리어 코드
     *   11. FLIGHT_NUM : 항공편 번호
     *   12. TAIL_NUM : 비행기 등록 번호
     *   13. ACTUAL_ELAPSED_TIME : 실제 운항 시간 (실제 출발 시간 - 실제 도착 시간)
     *   14. CRS_ELAPSED_TIME : 운항 예정 시간 (출발 예정 시간 - 도착 예정 시간)
     *   15. AIR_TIME : 상공에 머물러 있었던 시간
     *   16. ARR_DELAY : 도착 지연 시간 (분)
     *   17. DEP_DELAY : 출발 지연 시간 (분)
     *   18. ORIGIN : 출발지 공항 코드
     *   19. DEST : 목적지 공항 코드
     *   20. DISTANCE : 거리 (마일)
     *   21. TAXI_IN : 택시 들어온 시간
     *   22. TAXI_OUT : 택시 나간 시간
     *   23. CANCELLED : 운항 취소 여부 (0: 운항, 1: 취소)
     *   24. CANCELLATION_CODE : 항공 취소 코드 (A = 수하물, B= 날씨, C = 관제센터, D = 보안)
     *   25. DIVERTED : 우회 여부 (0: No, 1: Yes)
     *   26. CARRIER_DELAY : 캐리어 지연 시간 (분)
     *   27. WEATHER_DELAY : 날씨 지연 시간 (분)
     *   28. NAS_DELAY : 관제 지연 시간 (분)
     *   29. SECURITY_DELAY : 보안 지연 시간 (분)
     *   30. LATE_AIRCRAFT_DELAY : 늦은 항공기 지연 시간 (분)
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROW_ID")
    private Long RowId;

    @Column(name = "YEAR")
    private Integer Year;

    @Column(name = "MONTH")
    private Integer Month;

    @Column(name = "DAY_OF_MONTH")
    private Integer DayOfMonth;

    @Column(name = "DAY_OF_WEEK")
    private Integer DayOfWeek;

    @Column(name = "DEP_TIME")
    private Integer DepTime;

    @Column(name = "CRS_ARR_TIME")
    private Integer CRSArrTime;

    @Column(name = "CRS_DEP_TIME")
    private Integer CRSDepTime;

    @Column(name = "ARR_TIME")
    private Integer ArrTime;

    @Column(name = "UNIQUE_CARRIER", length = 5)
    private String UniqueCarrier;

    @Column(name = "FLIGHT_NUM")
    private Integer FlightNum;

    @Column(name = "TAIL_NUM", length = 8)
    private String TailNum;

    @Column(name = "ACTUAL_ELAPSED_TIME")
    private Integer ActualElapsedTime;

    @Column(name = "CRS_ELAPSED_TIME")
    private Integer CRSElapsedTime;

    @Column(name = "AIR_TIME")
    private Integer AirTime;

    @Column(name = "ARR_DELAY")
    private Integer ArrDelay;

    @Column(name = "DEP_DELAY")
    private Integer DepDelay;

    @Column(name = "ORIGIN", length = 3)
    private String Origin;

    @Column(name = "DEST", length = 3)
    private String Dest;

    @Column(name = "DISTANCE")
    private Integer Distance;

    @Column(name = "TAXI_IN")
    private Integer Taxiln;

    @Column(name = "TAXI_OUT")
    private Integer TaxiOut;

    @Column(name = "CANCELLED")
    private Integer Cancelled;

    @Column(name = "CANCELLATION_CODE", length = 1)
    private String CancellationCode;

    @Column(name = "DIVERTED", length = 1)
    private String Diverted;

    @Column(name = "CARRIER_DELAY")
    private Integer CarrierDelay;

    @Column(name = "WEATHER_DELAY")
    private Integer WeatherDelay;

    @Column(name = "NAS_DELAY")
    private Integer NASDelay;

    @Column(name = "SECURITY_DELAY")
    private Integer SecurityDelay;

    @Column(name = "LATE_AIRCRAFT_DELAY")
    private Integer LateAircraftDelay;
}
