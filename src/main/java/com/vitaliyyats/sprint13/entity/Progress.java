package com.vitaliyyats.sprint13.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Progress {

    public enum TaskStatus {
        PASS, FAIL, PENDING
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDate started;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @UpdateTimestamp
    private LocalDate updated;

    @ManyToOne(cascade = CascadeType.ALL)
    private Task task;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
}
