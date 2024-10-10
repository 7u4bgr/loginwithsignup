package com.example.newdockersql.controller;

import com.example.newdockersql.dtopackage.StudentsDto;
import com.example.newdockersql.model.Students;
import com.example.newdockersql.service.StudentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class StudentsController {
    private final StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }
    @GetMapping("/all")
    public List<StudentsDto> all() {
        return studentsService.getAll();
    }
    @PostMapping("/save")
    public StudentsDto registerUser(@RequestBody StudentsDto studentsDto) {
        return studentsService.registerUser(studentsDto);
    }

    @DeleteMapping("/deleteallusers")
    public String deleteAllStudents(@RequestBody StudentsDto studentsDto) {
        studentsService.deleteAllStudents(studentsDto);
        return "Hamisi silindi";
    }
    @PostMapping("/login")
    public StudentsDto loginUser(@RequestBody StudentsDto studentsDto) {
        return studentsService.loginUser(studentsDto);
    }
}
