package com.example.ss_test_without_ai.utils;

import com.example.ss_test_without_ai.domain.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentConverterTest {
    private StudentConverter converter;

    @BeforeEach
    public void setUp() {
        converter = new StudentConverter();
    }

    @Test
    public void testConvertStudentsHighAchiever() {
        //Given
        Student student = createStudent(22, 95);
        List<Student> students = List.of(student);

        //When
        List<Student> convertedStudents = converter.convertStudents(students);

        //Then
        assertEquals(1, convertedStudents.size());
        assertTrue(convertedStudents.get(0).isHonorRoll());
    }

    @Test
    public void testConvertStudentsExceptionalYoungHighAchiever() {
        //Given
        Student student = createStudent(20, 95);
        List<Student> students = List.of(student);

        //When
        List<Student> convertedStudents = converter.convertStudents(students);

        assertEquals(1, convertedStudents.size());
        assertTrue(convertedStudents.get(0).isExceptional());
    }

    @Test
    public void testConvertStudentsPassedStudent() {
        Student student = createStudent(21, 85);
        List<Student> students = List.of(student);

        List<Student> convertedStudents = converter.convertStudents(students);

        assertEquals(1, convertedStudents.size());
        assertTrue(convertedStudents.get(0).isPassed());
    }

    @Test
    public void testConvertStudentsFailedStudent() {
        Student student = createStudent(19, 60);
        List<Student> students = List.of(student);

        List<Student> convertedStudents = converter.convertStudents(students);

        assertEquals(1, convertedStudents.size());
        assertFalse(convertedStudents.get(0).isPassed());
    }

    @Test
    public void testConvertStudentsEmptyArray() {
        List<Student> students = new ArrayList<>();

        List<Student> convertedStudents = converter.convertStudents(students);

        assertEquals(0, convertedStudents.size());
    }

    @Test
    public void testConvertStudentsNullInput() {
        assertThrows(NullPointerException.class, () -> converter.convertStudents(null));
    }

    private Student createStudent(int age, int grade) {
        Student student = new Student();
        student.setAge(age);
        student.setGrade(grade);
        return student;
    }
}