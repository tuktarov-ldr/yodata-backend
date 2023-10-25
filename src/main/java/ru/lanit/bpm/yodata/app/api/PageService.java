package ru.lanit.bpm.yodata.app.api;

public interface PageService {
    void addPage(String name, String url, String parsingXPath) throws DuplicateEntityException;
}
