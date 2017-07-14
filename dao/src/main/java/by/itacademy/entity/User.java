package by.itacademy.entity;

import by.itacademy.entity.common.BaseEntity;
import by.itacademy.entity.other.Address;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@NoArgsConstructor
@ToString(callSuper = true, exclude = {"roleOfUser", "messages", "createdTopics"})
public class User extends BaseEntity {

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Column(name = "login")
    @Getter
    @Setter
    private String name;

    @Column(name = "password")
    @Getter
    @Setter
    private String password;

    @Column(name = "name")
    @Getter
    @Setter
    private String firstName;

    @Column(name = "mail")
    @Getter
    @Setter
    private String mail;

    @Column(name = "pass_to_picture")
    @Getter
    @Setter
    private String srcAvatar;

    @Getter
    @Setter
    @Embedded
    private Address address;

    @Getter
    @Setter
    @OneToMany(mappedBy = "user")
    private List<Topic> createdTopics = new ArrayList<>();

    @Getter
    @Setter
    @OneToMany(mappedBy = "user")
    private List<Message> messages = new ArrayList<>();

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private List<RoleOfUser> roleOfUser = new ArrayList<>(4);
}
