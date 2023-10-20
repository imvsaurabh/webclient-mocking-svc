package com.github.imvsaurabh.dockertest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DockerTestApplicationTests {

    @Test
    void contextLoads() {
        Application.main(new String[] {});
    }

}
