package ru.lanit.bpm.yodata.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lanit.bpm.yodata.app.api.DuplicateEntityException;
import ru.lanit.bpm.yodata.app.api.PageService;
import ru.lanit.bpm.yodata.domain.Page;

@RequiredArgsConstructor
@RestController
@RequestMapping("/yodata/admin/pages")
public class PageController {
    private final PageService pageService;

    @PostMapping
    public ResponseEntity<String> createPage (@RequestBody Page page) {
        try {
            pageService.addPage(page.getName(), page.getUrl(), page.getParsingXPath());
            return ResponseEntity.ok("Page created");
        } catch (DuplicateEntityException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
