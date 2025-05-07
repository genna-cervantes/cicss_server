package ust.com.cicss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ust.com.cicss.models.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {
}
