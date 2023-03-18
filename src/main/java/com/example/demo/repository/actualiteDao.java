package com.example.demo.repository;

import com.example.demo.entity.Actualite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface actualiteDao extends JpaRepository<Actualite, Long> {


}
