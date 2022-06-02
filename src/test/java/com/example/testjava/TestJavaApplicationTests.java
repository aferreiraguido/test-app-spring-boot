package com.example.testjava;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class TestJavaApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate rest;

    private String generateUrlForTestParameters(String effectiveDate, Integer productId, Integer brandId) {
        String host = "http://localhost";
        String path = "/v1/price/byEffectiveDate";
        return String.format("%s:%d%s?effectiveDate=%s&productId=%d&brandId=%d",
            host, port, path, effectiveDate, productId, brandId);
    }

    private String jsonTagValuePairToString(String tag, String value) {
        return String.format("\"%s\":\"%s\"", tag, value);
    }

    @Test
    void test_rest_001() throws Exception {
        assertThat(
            rest.getForObject(
                generateUrlForTestParameters("2020-06-14-10.00.00", 35455, 1),
                String.class))
            .contains(jsonTagValuePairToString("price", "35.5"));
    }

    @Test
    void test_rest_002() throws Exception {
        assertThat(
            rest.getForObject(
                generateUrlForTestParameters("2020-06-14-16.00.00", 35455, 1),
                String.class))
            .contains(jsonTagValuePairToString("price", "25.45"));
    }

    @Test
    void test_rest_003() throws Exception {
        assertThat(
            rest.getForObject(
                generateUrlForTestParameters("2020-06-14-21.00.00", 35455, 1),
                String.class))
            .contains(jsonTagValuePairToString("price", "35.5"));
    }

    @Test
    void test_rest_004() throws Exception {
        assertThat(
            rest.getForObject(
                generateUrlForTestParameters("2020-06-15-10.00.00", 35455, 1),
                String.class))
            .contains(jsonTagValuePairToString("price", "30.5"));
    }

    @Test
    void test_rest_005() throws Exception {
        assertThat(
            rest.getForObject(
                generateUrlForTestParameters("2020-06-16-21.00.00", 35455, 1),
                String.class))
            .contains(jsonTagValuePairToString("price", "38.95"));
    }

    @Test
    void test_rest_006() throws Exception {
        assertThat(
            rest.getForObject(
                generateUrlForTestParameters("2021-06-16-00.00.00", 35455, 1),
                String.class))
            .isEqualTo("result-set-is-empty");
    }
}
