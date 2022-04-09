package com.meli.qa.qabugs.dto.mapping;

import com.meli.qa.qabugs.dto.TestCaseRequest;
import com.meli.qa.qabugs.entity.TestCase;

import java.time.LocalDate;

public class TestCaseRequestToTestCase {
    public TestCase convert(TestCaseRequest request) {
        return TestCase.builder()
                .description(request.getDescription())
                .tested(request.getTested())
                .passed(request.getPassed())
                .numberOfTries(request.getNumberOfTries())
                .lastUpdate(LocalDate.now())
                .build();
    }
}
