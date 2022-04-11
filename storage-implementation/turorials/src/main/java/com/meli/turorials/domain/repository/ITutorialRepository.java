package com.meli.turorials.domain.repository;

import com.meli.turorials.domain.entity.Tutorial;

import java.util.List;
import java.util.Optional;

public interface ITutorialRepository {
    List<Tutorial> findAll();
    Tutorial create(Tutorial tutorial);
    Optional<Tutorial> findById(Long id);
    void remove(Long id);
    void update(Tutorial tutorial);
}
