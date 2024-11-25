package com.example.demo.student;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    @DisplayName("Should find student by email if present")
    void findStudentByEmailWhenPresent() {
        // Arrange
        Student student = new Student("John Doe", "john.doe@example.com", LocalDate.of(1999, Month.APRIL, 10));
        studentRepository.save(student);

        // Act
        Optional<Student> result = studentRepository.findStudentByEmail("john.doe@example.com");

        // Assert
        assertThat(result).isPresent();
        assertThat(result.get().getEmail()).isEqualTo("john.doe@example.com");
    }
}