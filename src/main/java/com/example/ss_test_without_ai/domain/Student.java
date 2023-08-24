package com.example.ss_test_without_ai.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Student {
    private String name;
    private int age;
    private int grade;
    private boolean exceptional;
    private boolean honorRoll;
    private boolean passed;

}
