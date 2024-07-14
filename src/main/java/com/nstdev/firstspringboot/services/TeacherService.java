package com.nstdev.firstspringboot.services;

import com.nstdev.firstspringboot.models.Position;
import com.nstdev.firstspringboot.models.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();
    void createTeacher(Teacher teacher);
    Teacher getTeacherById(int id);
    void deleteTeacherById(int id);
    List<Position> getAllPositions();
}
