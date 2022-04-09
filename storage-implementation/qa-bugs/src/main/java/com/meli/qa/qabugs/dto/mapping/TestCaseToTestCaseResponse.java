package com.meli.qa.qabugs.dto.mapping;

import com.meli.qa.qabugs.dto.TestCaseResponse;
import com.meli.qa.qabugs.entity.TestCase;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TestCaseToTestCaseResponse {
    public TestCaseResponse convert(TestCase entity) {
        return TestCaseResponse.builder()
                .idCase(entity.getId())
                .description(entity.getDescription())
                .tested(entity.getTested())
                .passed(entity.getPassed())
                .numberOfTries(entity.getNumberOfTries())
                .lastUpdate(LocalDate.now())
                .build();
    }

    public List<TestCaseResponse> convertList(List<TestCase> entities) {
        return entities.stream().map(entity -> convert(entity)).collect(Collectors.toList());
    }
}
