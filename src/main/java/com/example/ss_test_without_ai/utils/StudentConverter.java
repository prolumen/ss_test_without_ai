package com.example.ss_test_without_ai.utils;

import com.example.ss_test_without_ai.domain.Student;

import java.util.List;
import java.util.stream.Collectors;

public class StudentConverter {
    private static final int AGE_MIN = 21;
    private static final int HIGH_GRADE = 90;
    private static final int MIN_GRADE = 70;

    public List<Student> convertStudents(List<Student> students) {

        return students.stream().map(student ->
        {
            Student result = new Student();

            result.setName(student.getName());
            result.setAge(student.getAge());
            result.setGrade(student.getGrade());

            if (student.getGrade() > HIGH_GRADE) {
                    applyCriteriaByAge(student.getAge(), result);
            }
            result.setPassed(isPassed(student));

            return result;
        }).collect(Collectors.toList());
    }

    private Student applyCriteriaByAge (int age, Student student) {
        if ((age < AGE_MIN)) {
            student.setExceptional(true);
        } else {
            student.setHonorRoll(true);
        }
        return student;
    }

    private boolean isPassed(Student student) {
        return student.getGrade() > MIN_GRADE ? true : false;
    }
}