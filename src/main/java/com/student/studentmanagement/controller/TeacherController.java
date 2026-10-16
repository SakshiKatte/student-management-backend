package com.student.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.student.studentmanagement.entity.Teacher;
import com.student.studentmanagement.repository.TeacherRepository;

import java.util.Optional;

@RestController
@RequestMapping("/teachers")
@CrossOrigin(origins = {
    "http://localhost:5173",
    "http://localhost:5174",
    "https://student-management-frontend-red.vercel.app"
})
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @PostMapping("/login")
    public String login(@RequestBody Teacher loginTeacher) {

        Optional<Teacher> teacher =
                teacherRepository.findByUsername(loginTeacher.getUsername());

        if (teacher.isPresent()
                && teacher.get().getPassword()
                .equals(loginTeacher.getPassword())) {

            return "Login successful";
        }

        return "Invalid username or password";
    }
}
