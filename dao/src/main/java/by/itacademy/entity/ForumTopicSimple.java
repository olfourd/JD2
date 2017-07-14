package by.itacademy.entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "simple_forum_topic")
@PrimaryKeyJoinColumn(name = "TOPIC_ID")
@ToString(exclude = {"containedPosts"}, callSuper = true)
public class ForumTopicSimple extends Topic {

    public ForumTopicSimple(String name, String text, User user, ForumTopicGlobal theme) {
        super(name, text, user);
        this.theme = theme;
    }

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "GLOBAL_FORUM_TOPIC_ID")
    private ForumTopicGlobal theme;

    @Getter
    @Setter
    @OneToMany(mappedBy = "forumTopic")
    private List<ForumPost> containedPosts = new ArrayList<>();
}
