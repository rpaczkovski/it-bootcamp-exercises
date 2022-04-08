package com.itbootcamp.storage.asperolas.repository;

import com.itbootcamp.storage.asperolas.entity.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewelRepository extends JpaRepository<Jewel, Long> {
}
