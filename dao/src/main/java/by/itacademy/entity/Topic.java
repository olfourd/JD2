package by.itacademy.entity;

import by.itacademy.entity.common.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "topic")
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@ToString(callSuper = true,exclude = {"user"})
public class Topic extends BaseEntity {

    public Topic(String name, String text, User user) {
        this.name = name;
        this.text = text;
        this.user = user;
    }

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "text", nullable = false)
    private String text;

    @Getter
    @Setter
    @Column(name = "date")
    private LocalDate dateOfCreation;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;
}
