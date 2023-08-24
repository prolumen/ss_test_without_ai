package com.example.ss_test_without_ai.domain;

import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Player {
    public String name;
    public int age;
    public int experience;
    public List<Integer> skills;
}
