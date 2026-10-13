package com.student.studentmanagement.service;

import com.student.studentmanagement.entity.Student;
import com.student.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

  
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    
    public Student updateStudent(Long id, Student studentDetails) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student != null) {

            student.setName(studentDetails.getName());
            student.setEmail(studentDetails.getEmail());
            student.setCourse(studentDetails.getCourse());
            student.setPhone(studentDetails.getPhone());

            return studentRepository.save(student);
        }

        return null;
    }

   
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}




