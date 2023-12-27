package ru.lanit.bpm.yodata.adapter.pageparser;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
class JsoupPageParserTest {

    private PageParser pageParser;

    @BeforeEach
    public void setUp() {
        pageParser = new JsoupPageParser();
    }

    @AfterEach
    public void tearDown() {
        pageParser = null;
    }

    @Test
    void getUrlContent() {
        String result = pageParser.getUrlContent("https://cbr.ru",
                "//div[@class='main-indicator_rate'][2]/div[contains(@class, 'mono-num')][2]/text()");
        log.info("Result: {}", result);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

}