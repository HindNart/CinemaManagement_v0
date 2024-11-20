package com.Group3.ManagementCinema;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountTest {
    private static final Logger log = LoggerFactory.getLogger(AccountTest.class);

    @Test
    void showAllAccount(){
        log.info("hello");
    }
}

