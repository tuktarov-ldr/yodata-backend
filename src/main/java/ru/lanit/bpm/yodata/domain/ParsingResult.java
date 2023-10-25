package ru.lanit.bpm.yodata.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parsing_results")
public class ParsingResult {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_parsing_results_id")
    @SequenceGenerator(name = "sq_parsing_results_id", allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "page_id")
    private Page page;
    private Instant parsingDateTime;
    private String result;
    private Boolean sent;
}
