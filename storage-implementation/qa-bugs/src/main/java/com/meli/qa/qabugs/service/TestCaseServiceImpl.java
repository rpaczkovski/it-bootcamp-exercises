package com.meli.qa.qabugs.service;

import com.meli.qa.qabugs.entity.TestCase;
import com.meli.qa.qabugs.exception.InvalidDateFormatTestCaseException;
import com.meli.qa.qabugs.exception.NotFoundTestCaseException;
import com.meli.qa.qabugs.repository.TestCaseRepository;
import com.meli.qa.qabugs.util.DateValidatorUsingLocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class TestCaseServiceImpl implements TestCaseService{

    @Autowired
    private TestCaseRepository repository;

    @Override
    public TestCase save(TestCase entity) {
        return repository.save(entity);
    }

    @Override
    public TestCase findById(Long id) {
        Optional<TestCase> optionalTestCase = repository.findById(id);
        optionalTestCase.orElseThrow(() -> new NotFoundTestCaseException("The test case not found."));
        return optionalTestCase.get();
    }

    @Override
    public List<TestCase> findAll() {
        return repository.findAll();
    }

    @Override
    public TestCase update(Long id, TestCase entity) {
        TestCase testCase = findById(id);
        testCase.setTested(entity.getTested());
        testCase.setDescription(entity.getDescription());
        testCase.setPassed(entity.getPassed());
        testCase.setNumberOfTries(entity.getNumberOfTries());
        testCase.setLastUpdate(entity.getLastUpdate());
        return repository.save(testCase);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<TestCase> findByLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateValidatorUsingLocalDate validator = new DateValidatorUsingLocalDate(formatter);

        if(!validator.isValid(date)) {
            throw new InvalidDateFormatTestCaseException("Invalid date format, use dd-MM-yyyy for the date format.");
        }

        return repository.findAllByLastUpdate(LocalDate.parse(date, formatter));
    }
}
