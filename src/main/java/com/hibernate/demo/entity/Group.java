package com.hibernate.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
public class Group {
    @Id
    @GeneratedValue
    private long id;

    private String Name;
}
