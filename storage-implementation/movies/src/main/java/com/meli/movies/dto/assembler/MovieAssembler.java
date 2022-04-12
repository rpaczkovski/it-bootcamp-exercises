package com.meli.movies.dto.assembler;

import com.meli.movies.dto.request.MovieRequest;
import com.meli.movies.dto.response.MovieResponse;
import com.meli.movies.entity.Movie;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MovieAssembler {

    private ModelMapper modelMapper;

    public Movie toDomainObject(MovieRequest request) {
        return modelMapper.map(request, Movie.class);
    }

    public MovieResponse toResponseObject(Movie entity) {
        return modelMapper.map(entity, MovieResponse.class);
    }
}

