package com.meli.movies.service.genre;

import com.meli.movies.entity.Genre;
import com.meli.movies.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService{

    private GenreRepository genreRepository;

    @Override
    public Genre create(Genre entity) {
        return null;
    }

    @Override
    public Genre findById(Long id) {
        return null;
    }

    @Override
    public List<Genre> findAll() {
        return null;
    }

    @Override
    public Genre update(Long id, Genre entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
