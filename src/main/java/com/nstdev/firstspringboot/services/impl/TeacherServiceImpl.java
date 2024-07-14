package com.nstdev.firstspringboot.services.impl;

import com.nstdev.firstspringboot.models.Position;
import com.nstdev.firstspringboot.models.Teacher;
import com.nstdev.firstspringboot.respositories.PositionRepository;
import com.nstdev.firstspringboot.respositories.TeacherRepository;
import com.nstdev.firstspringboot.services.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final PositionRepository positionRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository, PositionRepository positionRepository) {
        this.teacherRepository = teacherRepository;
        this.positionRepository = positionRepository;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public void createTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public Teacher getTeacherById(int id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteTeacherById(int id) {
        var teacher = teacherRepository.findById(id);
        if(teacher.isPresent()) {
            teacher.get().setStatus("DEL");
            teacherRepository.save(teacher.get());
        }
    }

    @Override
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }
}

