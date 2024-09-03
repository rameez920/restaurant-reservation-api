package com.rameez.restaurant.api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JdbcTest
@Import(DinerRepository.class)
public class DinerRepositoryTest {

    @Autowired
    private DinerRepository dinerRepository;


    @Test
    public void test() {
       List<String> dinerIds = List.of("1", "2");
       List<String> res = dinerRepository.getDinerRestrictions(dinerIds);
        assertEquals(2, res.size());
    }
}
