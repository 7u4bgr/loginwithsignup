package com.example.newdockersql.service;

import com.example.newdockersql.dtopackage.StudentsDto;
import com.example.newdockersql.mapper.StudentsMapper;
import com.example.newdockersql.model.Students;
import com.example.newdockersql.repository.Repository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentsService {
    private final Repository repository;
    private final StudentsMapper studentsMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public StudentsService(Repository repository, StudentsMapper studentsMapper, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.studentsMapper = studentsMapper;
        this.passwordEncoder = passwordEncoder;
    }

    //Yaddasa vurma
    public StudentsDto registerUser(StudentsDto studentsDto) {
        // Şifreyi hashle

        studentsDto.setPassword(passwordEncoder.encode(studentsDto.getPassword()));
        Students students = studentsMapper.studentsDtoToStudents(studentsDto);
        Students savedStudents = repository.save(students);
        return studentsMapper.studentsToStudentsDto(savedStudents);
    }

    // Öğrenci girişi için metot

    public List<StudentsDto> getAll() {
        List<Students> students = repository.findAll();
        return students.stream()
                .map(studentsMapper::studentsToStudentsDto)
                .collect(Collectors.toList());
    }

    public StudentsDto saveStudents(StudentsDto studentsDto) {
        Students students = studentsMapper.studentsDtoToStudents(studentsDto);
        Students savedStudents = repository.save(students);
        return studentsMapper.studentsToStudentsDto(savedStudents);
    }

    public void deleteAllStudents(StudentsDto studentsDto) {
        repository.deleteAll();
    }
    public StudentsDto loginUser(StudentsDto studentsDto) {
        try {
            Optional<Students> optionalStudent = Optional.ofNullable(repository.findByEmail(studentsDto.getEmail()));
            if (optionalStudent.isPresent()) {
                Students student = optionalStudent.get();
                if (passwordEncoder.matches(studentsDto.getPassword(), student.getPassword())) {
                    return studentsMapper.studentsToStudentsDto(student);
                }
            }
            throw new IllegalArgumentException("Geçersiz e-posta veya şifre");
        } catch (Exception e) {
            e.printStackTrace(); // Hata ayıklama için
            throw e; // İstisnayı tekrar fırlat
        }
    }


}
