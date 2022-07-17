package com.webproject.webprojectapi;

import com.webproject.webprojectapi.jpql.AvgAetByMonth;
import com.webproject.webprojectapi.repository.DataRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JPAQueryTest {

    @Autowired
    DataRepository dataRepository;

    @Test
    @DisplayName("JPA 순수 Query 작성으로 데이터를 조회해오는지 테스트")
    public void selectDataTest() {

        List<AvgAetByMonth> list = new ArrayList<>();

        list = dataRepository.findAvgActualElapsedTimeByMonth();
    }


}
