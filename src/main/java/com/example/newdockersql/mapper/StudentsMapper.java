package com.example.newdockersql.mapper;


import com.example.newdockersql.dtopackage.StudentsDto;
import com.example.newdockersql.model.Students;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentsMapper {
    @Mapping(source = "name",target = "name")
    @Mapping(source = "surname",target = "surname")
    @Mapping(source = "email",target = "email")
    @Mapping(source = "password",target = "password")
    StudentsDto studentsToStudentsDto(Students students);
    @Mapping(source = "name",target = "name")
    @Mapping(source = "surname",target = "surname")
    @Mapping(source = "email",target = "email")
    @Mapping(source = "password",target = "password")
    Students studentsDtoToStudents(StudentsDto studentsDto);


}
