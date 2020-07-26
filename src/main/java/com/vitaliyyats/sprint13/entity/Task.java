package com.vitaliyyats.sprint13.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDate created;

    @Column
    private String title;

    @UpdateTimestamp
    private LocalDate updated;

    @ManyToOne(cascade = CascadeType.ALL)
    private Sprint sprint;
}
