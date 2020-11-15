package com.hibernate.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Address {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "mySeqGen")
    private long id;

    private String street;
    private String stateCode;
    private String countryCode;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Student student;
}
