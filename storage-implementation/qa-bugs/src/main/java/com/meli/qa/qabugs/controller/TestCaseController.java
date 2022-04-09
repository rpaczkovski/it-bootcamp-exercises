package com.meli.qa.qabugs.controller;

import com.meli.qa.qabugs.dto.TestCaseRequest;
import com.meli.qa.qabugs.dto.TestCaseResponse;
import com.meli.qa.qabugs.dto.mapping.TestCaseRequestToTestCase;
import com.meli.qa.qabugs.dto.mapping.TestCaseToTestCaseResponse;
import com.meli.qa.qabugs.entity.TestCase;
import com.meli.qa.qabugs.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/testcases")
public class TestCaseController {

    @Autowired
    private TestCaseService service;

    @PostMapping("/new")
    public ResponseEntity<String> newTestCase(@Valid @RequestBody TestCaseRequest request, UriComponentsBuilder uriBuilder) {
       TestCase testCase = service.save(new TestCaseRequestToTestCase().convert(request));

        URI uri = uriBuilder
                .path("{id}")
                .buildAndExpand(testCase.getId())
                .toUri();

        return ResponseEntity.created(uri).body("The test case was created successfully.");
    }

    @GetMapping
        public ResponseEntity<List<TestCaseResponse>> getAllTestCases(@RequestParam(required = false, name = "last_update") String date) {
        if(date != null) {
            return ResponseEntity.ok().body(new TestCaseToTestCaseResponse().convertList(service.findByLocalDate(date)));
        }

        return ResponseEntity.ok().body(new TestCaseToTestCaseResponse().convertList(service.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<TestCaseResponse> getTestCase(@PathVariable long id) {
        return ResponseEntity.ok().body(new TestCaseToTestCaseResponse().convert(service.findById(id)));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateTestCase(@PathVariable long id, @Valid @RequestBody TestCaseRequest request) {
        service.update(id, new TestCaseRequestToTestCase().convert(request));
        return ResponseEntity.ok().body("The test case was successfully updated.");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTestCase(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.ok().body("The test case was successfully deleted.");
    }

}
