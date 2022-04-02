package com.example.photographinsta;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {PhotographInstaApplication.class, H2JpaConfig.class})
@ActiveProfiles("test")
class PhotographInstaApplicationTests {

    @Test
    void contextLoads() {
    }

}
