package ru.lanit.bpm.yodata.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pages")
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_pages_id")
    @SequenceGenerator(name = "sq_pages_id", allocationSize = 1)
    private Long id;
    private String name;
    private String url;
    @Column(name = "parsing_x_path")
    private String parsingXPath;

    Page (String)
}
