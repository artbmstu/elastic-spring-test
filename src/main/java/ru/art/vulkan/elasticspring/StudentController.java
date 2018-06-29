package ru.art.vulkan.elasticspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository repository;

    @PostMapping("/student/add")
    public StudentEntity addStudent(@RequestBody StudentEntity student){
        return repository.save(student);
    }

    @GetMapping("/student/all")
    public List<StudentEntity> getStudents(){
        Iterator<StudentEntity> iterator = repository.findAll().iterator();
        List<StudentEntity> students = new ArrayList<>();
        while (iterator.hasNext()){
            students.add(iterator.next());
        }
        return students;
    }

    @GetMapping("/student/{id}")
    public Optional<StudentEntity> getStudent(@PathVariable Integer id){
        return repository.findById(id);
    }

    @PutMapping("/student/{id}")
    public StudentEntity updateStudent(@PathVariable Integer id, @RequestBody StudentEntity student){
        Optional<StudentEntity> std = repository.findById(id);
        if (std.isPresent()){
            StudentEntity s = std.get();
            s.setName(student.getName());
            return repository.save(s);
        }
        else return null;
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable Integer id){
        repository.deleteById(id);
        return "Document Deleted";
    }
}
