package com.breakingbad.repository;

import com.breakingbad.model.Episodes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodesRepository extends JpaRepository<Episodes, Long> {
}
