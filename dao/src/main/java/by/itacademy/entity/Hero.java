package by.itacademy.entity;

import by.itacademy.entity.common.BaseEntity;
import by.itacademy.entity.other.HeroRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hero")
@NoArgsConstructor
public class Hero extends BaseEntity {

    public Hero(String name, HeroRole role) {
        this.name = name;
        this.role = role;
    }

    @Getter
    @Setter
    @Column(name = "name", nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(name = "pass")
    private String passToPicture;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private HeroRole role;

    @Getter
    @Setter
    @OneToMany(mappedBy = "hero")
    private List<HeroAbility> abilities = new ArrayList<>();
}
