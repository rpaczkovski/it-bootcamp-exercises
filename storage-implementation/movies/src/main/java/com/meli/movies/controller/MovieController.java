package com.meli.movies.controller;

import com.meli.movies.dto.assembler.MovieAssembler;
import com.meli.movies.dto.request.MovieRequest;
import com.meli.movies.dto.response.MovieResponse;
import com.meli.movies.entity.Movie;
import com.meli.movies.service.movie.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/movies")
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;
    private final MovieAssembler mapper;

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody MovieRequest request, UriComponentsBuilder uriBuilder) {
        Movie movie = movieService.create(mapper.toDomainObject(request));

        URI uri = uriBuilder
                .path("{id}")
                .buildAndExpand(movie.getId())
                .toUri();

        return ResponseEntity.created(uri).body("The entity created.");
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> getAll() {
        List<MovieResponse> result = movieService.findAll().stream()
                .map(movie -> mapper.toResponseObject(movie))
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @GetMapping("{id}")
    public ResponseEntity<MovieResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toResponseObject(movieService.findById(id)));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody MovieRequest request) {
        movieService.update(id, mapper.toDomainObject(request));
        return ResponseEntity.ok().body("The updated created.");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        movieService.delete(id);
        return ResponseEntity.ok().body("The updated deleted.");
    }

}
