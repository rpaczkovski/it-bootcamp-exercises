package com.meli.qa.qabugs.repository;

import com.meli.qa.qabugs.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findAllByLastUpdate(LocalDate date);
}
