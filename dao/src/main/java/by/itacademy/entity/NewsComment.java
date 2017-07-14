package by.itacademy.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "messages_from_news")
@PrimaryKeyJoinColumn(name = "MESSAGE_ID")
@ToString(callSuper = true, exclude = {"news"})
public class NewsComment extends Message {

    public NewsComment(String text, User user, News news) {
        super(text, user);
        this.news = news;
    }

    @ManyToOne
    @JoinColumn(name = "NEWS_ID")
    @Getter
    @Setter
    private News news;

    @Getter
    @Setter
    @Column(name = "likes")
    private long likeFromOthersUsers;
}
