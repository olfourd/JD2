package by.itacademy.entity;

import by.itacademy.entity.common.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "global_forum_topic")
@ToString(exclude = {"containedTopics"})
@EqualsAndHashCode(callSuper = true)

public class ForumTopicGlobal extends BaseEntity {

    public ForumTopicGlobal(String name) {
        this.name = name;
    }

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @OneToMany(mappedBy = "theme")
    private List<ForumTopicSimple> containedTopics = new ArrayList<>();
}
