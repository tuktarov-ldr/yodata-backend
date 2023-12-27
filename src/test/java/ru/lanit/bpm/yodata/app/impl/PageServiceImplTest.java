package ru.lanit.bpm.yodata.app.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.lanit.bpm.yodata.app.api.DuplicateEntityException;
import ru.lanit.bpm.yodata.app.api.PageService;
import ru.lanit.bpm.yodata.app.repo.PageRepository;
import ru.lanit.bpm.yodata.domain.Page;
import ru.lanit.bpm.yodata.fw.YodataBackendApplication;

import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = YodataBackendApplication.class)
class PageServiceImplTest {

    @Autowired
    PageRepository pageRepository;

    @Autowired
    PageService pageService;

    @Transactional
    @Test
    void addPage_success() throws DuplicateEntityException {
        pageService.addPage("test", "www.google.com", "div");


        Optional<Page> page = pageRepository.findByName("test");
        assertEquals("test", page.get().getName());
        assertEquals("www.google.com", page.get().getUrl());
        assertEquals("div", page.get().getParsingXPath());
    }
}