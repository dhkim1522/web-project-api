package com.webproject.webprojectapi.repository;

import com.webproject.webprojectapi.entity.Data;
import com.webproject.webprojectapi.jpql.AvgAetByDay;
import com.webproject.webprojectapi.jpql.AvgAetByMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DataRepository extends JpaRepository<Data, Long> {


    /**
     * @Title 미국항공운항정보 데이터셋
     * @Author dhkim1522(김동현)
     * @InitalDescription
     * > AET : ActualElapsedTime (실제 운항 시간)
     */

    // 월별 평균 항공 운행 시간
    @Query(value = "select month, round(avg(actual_elapsed_time), 1) as actualElapsedTime\n" +
            "from data\n" +
            "group by month", nativeQuery = true)
    List<AvgAetByMonth> findAvgAetByMonth();

    // 해당 월의 일별 평균 항공 운행 시간
    @Query(value = "select day_of_month as day, round(avg(actual_elapsed_time), 1) as actualElapsedTime\n" +
            "from data\n" +
            "where month = 1\n" +
            "group by day_of_month", nativeQuery = true)
    List<AvgAetByDay> findAvgAetByDay();
}



