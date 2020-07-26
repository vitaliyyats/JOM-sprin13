package com.vitaliyyats.sprint13.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Marathon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @ToString.Exclude
    @ManyToMany(mappedBy = "marathons", cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Sprint> sprints;
}
