package by.itacademy.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "TOPIC_ID")
@ToString(callSuper = true, exclude = {"containedComments"})
@EqualsAndHashCode(callSuper = true)

public class News extends Topic {

    public News(String name, String text, User user) {
        super(name, text, user);
    }

    @Getter
    @Setter
    @Column(name = "pass_to_picture")
    private String srcPicture;

    @Getter
    @Setter
    @OneToMany(mappedBy = "news")
    private List<NewsComment> containedComments = new ArrayList<>();
}
