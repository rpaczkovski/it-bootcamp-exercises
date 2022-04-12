package com.meli.movies.service.movie;

import com.meli.movies.entity.Genre;
import com.meli.movies.entity.Movie;
import com.meli.movies.exception.NotFoundGenreException;
import com.meli.movies.exception.NotFoundMovieException;
import com.meli.movies.repository.GenreRepository;
import com.meli.movies.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;
    private GenreRepository genreRepository;

    @Override
    @Transactional
    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Movie update(Long id, Movie movie) {
        Movie movieUpdated = this.findById(id);
        Optional<Genre> optionalGenre =  genreRepository.findById(movie.getGenre().getId());
        optionalGenre.orElseThrow(() -> new NotFoundGenreException());

        movieUpdated.updateEntity(
                movie.getTitle(),
                movie.getRating(),
                movie.getAwards(),
                movie.getReleaseDate(),
                movie.getLength(),
                movie.getActors(),
                movie.getGenre()
        );

        return movieRepository.save(movieUpdated);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Movie findById(Long id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        optionalMovie.orElseThrow(() -> new NotFoundMovieException());

        return optionalMovie.get();
    }
}
