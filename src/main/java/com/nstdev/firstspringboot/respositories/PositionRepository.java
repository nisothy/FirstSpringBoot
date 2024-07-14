package com.nstdev.firstspringboot.respositories;

import com.nstdev.firstspringboot.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PositionRepository extends JpaRepository<Position, Integer> {

}
