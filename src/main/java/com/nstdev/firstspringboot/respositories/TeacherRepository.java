package com.nstdev.firstspringboot.respositories;

import com.nstdev.firstspringboot.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer>
{

}
