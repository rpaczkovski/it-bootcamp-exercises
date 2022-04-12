package com.meli.movies.dto.assembler;

import com.meli.movies.dto.request.GenreRequest;
import com.meli.movies.dto.response.GenreResponse;
import com.meli.movies.entity.Genre;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GenreAssembler {

    private ModelMapper modelMapper;

    public Genre toDomainObject(GenreRequest request) {
        return modelMapper.map(request, Genre.class);
    }

    public GenreResponse toResponseObject(Genre entity) {
        return modelMapper.map(entity, GenreResponse.class);
    }
}

