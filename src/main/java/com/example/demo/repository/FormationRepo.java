package com.example.demo.repository;

import com.example.demo.entity.Formation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationRepo extends CrudRepository<Formation, Long> {

}
