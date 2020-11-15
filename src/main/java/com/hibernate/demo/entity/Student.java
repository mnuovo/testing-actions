package com.hibernate.demo.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "sequence_generator", sequenceName = "demo_seq", allocationSize = 10)
public class Student{

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "mySeqGen")
    private long id;

    private String firstName;
    private String lastName;

    private String phoneNumber;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
