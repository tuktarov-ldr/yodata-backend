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
@Table(name = "subscriptions")
public class  Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_subscriptions_id")
    @SequenceGenerator(name = "sq_subscriptions_id", allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "page_id")
    private Page page;
}
