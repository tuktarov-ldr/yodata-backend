package ru.lanit.bpm.yodata.domain;



import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "users")
public class User {
    @Id
    private String login;
    @ToString.Exclude
    private String password;
    private String firstName;
    private String lastName;
    private Long telegramId;

}
