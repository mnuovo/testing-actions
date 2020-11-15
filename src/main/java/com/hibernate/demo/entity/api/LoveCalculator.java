package com.hibernate.demo.entity.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LoveCalculator {
    private String fname;
    private String sname;
    private String percentage;
    private String result;
}
