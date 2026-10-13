package com.student.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.studentmanagement.entity.Teacher;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    Optional<Teacher> findByUsername(String username);

}