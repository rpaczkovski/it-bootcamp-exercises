package com.meli.qa.qabugs.service;

import com.meli.qa.qabugs.entity.TestCase;

import java.util.List;

public interface TestCaseService extends GenericService<Long, TestCase> {
    List<TestCase> findByLocalDate(String date);
}
