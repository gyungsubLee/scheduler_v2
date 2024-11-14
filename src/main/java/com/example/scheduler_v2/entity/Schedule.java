package com.example.scheduler_v2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Schedule extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    private String descriptiom;

    public Schedule(String title, String descriptiom) {
        this.title = title;
        this.descriptiom = descriptiom;
    }

    public void update(String title, String descriptiom){
        this.title = title;
        this.descriptiom = descriptiom;
    }
}
