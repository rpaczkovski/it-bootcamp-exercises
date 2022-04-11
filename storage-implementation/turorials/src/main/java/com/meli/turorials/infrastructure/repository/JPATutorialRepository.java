package com.meli.turorials.infrastructure.repository;

import com.meli.turorials.infrastructure.data.TutorialTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPATutorialRepository extends JpaRepository<TutorialTable, Long> {
}
