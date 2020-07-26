package com.vitaliyyats.sprint13.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate start;

    @Column
    private LocalDate finish;

    @Column
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    Marathon marathon;
}
