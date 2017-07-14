package by.itacademy.entity;


import by.itacademy.entity.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "message")
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@ToString(callSuper = true)
public class Message extends BaseEntity {

    public Message(String text, User user) {
        this.text = text;
        this.user = user;
    }

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
