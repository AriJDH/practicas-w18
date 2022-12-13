package com.dh.demo.integration;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {"SCOPE = integration_test"})
public class IntegrationTest {
}
