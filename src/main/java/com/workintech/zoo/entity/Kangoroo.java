package com.workintech.zoo.entity;

import lombok.Data;

@Data
public class Kangoroo {
    private Integer id;
    private String name;
    private Double weight;
    private Double height;
    private String gender;
    private Boolean isAggressive;
}
