package ru.lanit.bpm.yodata.app.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.lanit.bpm.yodata.app.api.DuplicateEntityException;
import ru.lanit.bpm.yodata.app.api.PageService;
import ru.lanit.bpm.yodata.app.repo.PageRepository;
import ru.lanit.bpm.yodata.domain.Page;

@RequiredArgsConstructor
@Service
@Slf4j
public class PageServiceImpl implements PageService {

    private final PageRepository pageRepository;

    @Override
    public void addPage(String name, String url, String parsingXPath) throws DuplicateEntityException {
        if(pageRepository.findByName(name).isPresent()){
            throw new DuplicateEntityException("Page with this name exists");
        } else {
            pageRepository.save(new Page(name, url, parsingXPath));
        }
    }
}
