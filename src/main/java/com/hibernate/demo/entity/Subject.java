package com.hibernate.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
public class Subject {

    @Id
    private long id;

    private String title;
}
