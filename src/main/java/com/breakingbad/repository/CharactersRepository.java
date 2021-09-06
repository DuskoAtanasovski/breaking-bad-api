package com.breakingbad.repository;

import com.breakingbad.model.Characters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CharactersRepository extends JpaRepository<Characters, Long> {

}
