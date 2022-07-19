package com.webproject.webprojectapi.repository;

import com.webproject.webprojectapi.entity.Data;
import com.webproject.webprojectapi.queryInterface.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DataRepository extends JpaRepository<Data, Long> {


    /**
     * @Title 미국항공운항정보 데이터셋
     * @Author dhkim1522(김동현)
     * @InitalDescription
     * > Aet : ActualElapsedTime (실제 운항 시간)
     */

    // 월별 평균 항공 운항 시간
    @Query(value = "select month, round(avg(actual_elapsed_time), 1) as avgAet\n" +
            "from data\n" +
            "group by month", nativeQuery = true)
    List<AvgAetMonth> findAvgAetMonth();

    // 일별 평균 항공 운항 시간
    @Query(value = "select day_of_month as day, round(avg(actual_elapsed_time), 1) as avgAet\n" +
            "from data\n" +
            "where month = ?1\n" +
            "group by day_of_month", nativeQuery = true)
    List<AvgAetDay> findAvgAetDay(Integer month);

    // 월별 평균 항공 출발 지연 시간 (분)
    @Query(value = "select month, round(avg(dep_delay), 1) as avgDepDelay\n" +
            "from data\n" +
            "where dep_delay >= 0\n" +
            "group by month", nativeQuery = true)
    List<AvgDepDelayMonth> findAvgDepDelayMonth();

    // 일별 평균 항공 출발 지연 시간 (분)
    @Query(value = "select day_of_month as day, round(avg(dep_delay), 1) as avgDepDelay\n" +
            "from data\n" +
            "where month = ?1\n" +
            "and dep_delay >= 0\n" +
            "group by day_of_month", nativeQuery = true)
    List<AvgDepDelayDay> findAvgDepDelayDay(Integer month);

    // 전체 지연 사유 별 개수
    @Query(value = "select  SUM(if(carrier_delay > 0, 1, 0)) as carrierDelayCount,\n" +
            "\t\tSUM(if(weather_delay > 0, 1, 0)) as weatherDelayCount,\n" +
            "\t\tSUM(if(nas_delay > 0, 1, 0)) as nasDelayCount,\n" +
            "\t\tSUM(if(security_delay > 0, 1, 0)) as securityDelayCount,\n" +
            "\t\tSUM(if(late_aircraft_delay > 0, 1, 0)) as lateAircraftDelayCount\n" +
            "from data", nativeQuery = true)
    List<DelayCount> findDelayCount();

    // 전체 지연 사유 별 분포량 (백분율)
    @Query(value = "select round((carrier_delay_count / all_count * 100), 1) as carrierDelayRate,\n" +
            "       round(weather_delay_count / all_count * 100, 1) as weatherDelayRate,\n" +
            "       round(nas_delay_count / all_count * 100, 1) as nasDelayRate,\n" +
            "       round(security_delay_count / all_count * 100, 1) as securityDelayRate,\n" +
            "       round(late_aircraft_delay_count / all_count * 100, 1) as lateAircraftDelayRate\n" +
            "from (\n" +
            "\tselect (carrier_delay_count\n" +
            "\t\t+ weather_delay_count\n" +
            "\t\t+ nas_delay_count\n" +
            "\t\t+ security_delay_count\n" +
            "\t\t+ late_aircraft_delay_count) all_count,\n" +
            "\t\tdata.*\n" +
            "\tfrom (\n" +
            "\t\tselect  SUM(if(carrier_delay > 0, 1, 0)) as carrier_delay_count,\n" +
            "\t\t\t\tSUM(if(weather_delay > 0, 1, 0)) as weather_delay_count,\n" +
            "\t\t\t\tSUM(if(nas_delay > 0, 1, 0)) as nas_delay_count,\n" +
            "\t\t\t\tSUM(if(security_delay > 0, 1, 0)) as security_delay_count,\n" +
            "\t\t\t\tSUM(if(late_aircraft_delay > 0, 1, 0)) as late_aircraft_delay_count\n" +
            "\t\tfrom data\n" +
            "\t) data\n" +
            "  ) x", nativeQuery = true)
    List<DelayRate> findDelayRate();


    // 운항 취소 및 우회 운항 건 수
    @Query(value = "select cancelCount, divertCount\n" +
            "from (\n" +
            "select COUNT(*) as cancelCount\n" +
            "from data\n" +
            "where cancelled = 1) x,\n" +
            "(select COUNT(*) as divertCount  \n" +
            "from data\n" +
            "where diverted = 1) y", nativeQuery = true)
    List<CancelDivertCount> findCancelDivertCount();

    // 운항 취소 코드 별 건 수
    @Query(value = "select cancellation_code as cancelCode, COUNT(*) as count  \n" +
            "from data\n" +
            "WHERE cancelled = 1\n" +
            "group by cancellation_code ", nativeQuery = true)
    List<CancelCodeCount> findCancelCodeCount();

    // 전체 데이터 개수
    Long countBy();
}



