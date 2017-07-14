package by.itacademy.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "forum_post")
@PrimaryKeyJoinColumn(name = "MESSAGE_ID")
@ToString(exclude = {"forumTopic"})
@EqualsAndHashCode(callSuper = true)
public class ForumPost extends Message {

    public ForumPost(String text, User user, ForumTopicSimple forumTopic) {
        super(text, user);
        this.forumTopic = forumTopic;
    }

    @Getter
    @Setter
    @Column(name = "likes")
    private long likes;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "SIMPLE_FORUM_TOPIC_ID")
    private ForumTopicSimple forumTopic;
}
