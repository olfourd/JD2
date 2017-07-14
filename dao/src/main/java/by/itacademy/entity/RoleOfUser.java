package by.itacademy.entity;

import by.itacademy.entity.common.BaseEntity;
import by.itacademy.entity.other.UserRole;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class RoleOfUser extends BaseEntity {

    public RoleOfUser(UserRole role) {
        this.role = role;
    }

    @Getter
    @Setter
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Getter
    @Setter
    @ManyToMany(mappedBy = "roleOfUser")
    List<User> users = new ArrayList<>(4);
}
