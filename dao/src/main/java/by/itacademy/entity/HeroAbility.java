package by.itacademy.entity;

import by.itacademy.entity.common.BaseEntity;
import by.itacademy.entity.other.KeyAbility;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ability")
@NoArgsConstructor
public class HeroAbility extends BaseEntity {

    public HeroAbility(String name, KeyAbility keyAbility, Hero hero) {
        this.name = name;
        this.keyAbility = keyAbility;
        this.hero = hero;
    }

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "key_ability")
    private KeyAbility keyAbility;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "HERO_ID")
    private Hero hero;

    @Getter
    @Setter
    @Column(name = "pass_to_img")
    private String passToImg;

    @Getter
    @Setter
    @Column(name = "pass_to_video")
    private String passToVideo;

}
