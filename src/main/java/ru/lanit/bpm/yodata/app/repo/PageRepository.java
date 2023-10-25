package ru.lanit.bpm.yodata.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lanit.bpm.yodata.domain.Page;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {
}
