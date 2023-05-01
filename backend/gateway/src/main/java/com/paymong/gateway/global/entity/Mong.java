package com.paymong.gateway.global.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "mong_entity")    // R2D2에선 인식 X
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Mong {

    @Id
    @Column(name = "mong_id")
    private Long mongId;
    @Column(name = "member_id")
    private Long memberId;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "reg_dt")
    private LocalDate regDt;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "age")
    private Integer age;
    @Column(name = "strength")
    private Integer strength;
    @Column(name = "satiety")
    private Integer satiety;
    @Column(name = "health")
    private Integer health;
    @Column(name = "sleep")
    private Integer sleep;
    @Column(name = "penalty")
    private Integer penalty;
    @Column(name = "training_count")
    private Integer trainingCount;
    @Column(name = "stroke_count")
    private Integer strokeCount;
    @Column(name = "poop_count")
    private Integer poopCount;
    @Column(name = "sleep_start")
    private LocalTime sleepStart;
    @Column(name = "sleep_end")
    private LocalTime sleepEnd;
    @Column(name = "complete")
    private Boolean complete;
}