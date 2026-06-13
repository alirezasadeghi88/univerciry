package com.lern.demo.service;

import com.lern.demo.model.Student;
import com.lern.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student save(Student student) {
       return studentRepository.save(student);
    }

    public List<Student> students(){
        return studentRepository.findAll();
    }

    public Student student(long id){
        return studentRepository.findById(id).get();
    }

    public void deleted(long id){
        studentRepository.deleteById(id);
    }

    public Student update(long id, Student student){
        Optional<Student> studentDataOpt = studentRepository.findById(id);
        Student studentData = studentDataOpt.get();
        
        if(student.getFirstname() != null && !student.getFirstname().isEmpty() && !student.getFirstname().equals("")){
            studentData.setFirstname(student.getFirstname());
        }

        if (student.getLastname() != null && !student.getLastname().isEmpty() && !student.getLastname().equals("")){
            studentData.setLastname(student.getLastname());
        }

        if (student.getAge() > 0 ){
            studentData.setAge(student.getAge());
        }

        return studentRepository.save(studentData);
    }

}
