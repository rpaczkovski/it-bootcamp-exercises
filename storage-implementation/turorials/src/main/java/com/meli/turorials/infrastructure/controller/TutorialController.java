package com.meli.turorials.infrastructure.controller;

import com.meli.turorials.application.usecase.tutorial.comman.TutorialResponseModel;
import com.meli.turorials.application.usecase.tutorial.create.CreateTutorialRequestModel;
import com.meli.turorials.application.usecase.tutorial.create.CreateTutorialUseCase;
import com.meli.turorials.application.usecase.tutorial.findall.FindAllTutorialUseCase;
import com.meli.turorials.application.usecase.tutorial.findbyid.FindByIdTutorialUseCase;
import com.meli.turorials.application.usecase.tutorial.update.UpdateTutorialRequestModel;
import com.meli.turorials.application.usecase.tutorial.update.UpdateTutorialUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("tutorials")
@AllArgsConstructor
public class TutorialController {

    private final CreateTutorialUseCase createTutorialUseCase;
    private final FindAllTutorialUseCase findAllTutorialUseCase;
    private final FindByIdTutorialUseCase findByIdTutorialUseCase;
    private final UpdateTutorialUseCase updateTutorialUseCase;

    @PostMapping()
    public ResponseEntity<String> create(@RequestBody CreateTutorialRequestModel request, UriComponentsBuilder uriBuilder) {
        TutorialResponseModel tutorial = createTutorialUseCase.execute(request);
        URI uri = uriBuilder
                .path("{id}")
                .buildAndExpand(tutorial.getId())
                .toUri();

        return ResponseEntity.created(uri).body("The tutorial was created successfully.");

    }

    @GetMapping
    public ResponseEntity<List<TutorialResponseModel>> findAll() {
        return ResponseEntity.ok().body(findAllTutorialUseCase.execute());
    }

    @GetMapping("{id}")
    public ResponseEntity<TutorialResponseModel> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(findByIdTutorialUseCase.execute(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable long id, @RequestBody UpdateTutorialRequestModel request) {
        updateTutorialUseCase.execute(id, request);
        return ResponseEntity.ok().body("The tutorial was successfully updated.");
    }

}
