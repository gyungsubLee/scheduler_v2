package com.example.scheduler_v2.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    private String descriptiom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // 생성 메서드
    public static Schedule createSchedule(String title, String descriptiom, Member member){
        Schedule schedule = new Schedule();
        schedule.title = title;
        schedule.descriptiom = descriptiom;
        schedule.setMember(member);
        return schedule;
    }

    // 연관관계 메서드, private 선언
    private void setMember ( Member member ){
        this.member = member;
        member.getScheduleList().add(this);
    }

    public void update(String title, String descriptiom){
        this.title = title;
        this.descriptiom = descriptiom;
    }



}
