package com.breakingbad.repository;

import com.breakingbad.model.Characters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CharactersRepository extends JpaRepository<Characters, Long> {

    Optional<Characters> findByName(String name);

}
