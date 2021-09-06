package com.breakingbad.repository;

import com.breakingbad.model.Deaths;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeathsRepository extends JpaRepository<Deaths, Long> {
}
