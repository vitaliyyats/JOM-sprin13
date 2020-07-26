package com.vitaliyyats.sprint13.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {
    public enum Role {
        MENTOR, TRAINEE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Marathon> marathons;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Sprint> sprints;
}
