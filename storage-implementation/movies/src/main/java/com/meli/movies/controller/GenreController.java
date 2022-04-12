package com.meli.movies.controller;

import com.meli.movies.dto.assembler.GenreAssembler;
import com.meli.movies.dto.request.GenreRequest;
import com.meli.movies.dto.response.GenreResponse;
import com.meli.movies.entity.Genre;
import com.meli.movies.service.genre.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/genres")
@AllArgsConstructor
public class GenreController {

    private GenreService genreService;
    private final GenreAssembler mapper;

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody GenreRequest request, UriComponentsBuilder uriBuilder) {
        Genre genre = genreService.create(mapper.toDomainObject(request));

        URI uri = uriBuilder
                .path("{id}")
                .buildAndExpand(genre.getId())
                .toUri();

        return ResponseEntity.created(uri).body("The entity created.");
    }

    @GetMapping
    public ResponseEntity<List<GenreResponse>> getAll() {
        List<GenreResponse> result = genreService.findAll().stream()
                .map(genre -> mapper.toResponseObject(genre))
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @GetMapping("{id}")
    public ResponseEntity<GenreResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toResponseObject(genreService.findById(id)));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody GenreRequest request) {
        genreService.update(id, mapper.toDomainObject(request));
        return ResponseEntity.ok().body("The updated created.");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        genreService.delete(id);
        return ResponseEntity.ok().body("The updated deleted.");
    }

}
