package ru.lanit.bpm.yodata.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lanit.bpm.yodata.domain.ParsingResult;
import ru.lanit.bpm.yodata.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface ParsingResultRepository  extends JpaRepository<ParsingResult, Long> {

    Optional<ParsingResult> findById(Long id);
}
