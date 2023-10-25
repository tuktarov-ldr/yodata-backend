package ru.lanit.bpm.yodata.app.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lanit.bpm.yodata.app.api.DuplicateEntityException;
import ru.lanit.bpm.yodata.app.api.PageService;
import ru.lanit.bpm.yodata.app.repo.PageRepository;

@RequiredArgsConstructor
@Service
public class PageServiceImpl implements PageService {
    private final PageRepository pageRepository;

    @Override
    public void addPage(String name, String url, String parsingXPath) throws DuplicateEntityException {
        if(pageRepository.findByName().isPresent()){
            throw new DuplicateEntityException("Page with this name exists");
        } else {
            pageRepository.save
        }
    }
}
