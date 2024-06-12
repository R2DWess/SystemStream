package com.wzzy.virtualmovies.movie.service;

import com.wzzy.virtualmovies.movie.Movie;
import com.wzzy.virtualmovies.movie.repository.MovieRepository;
import com.wzzy.virtualmovies.usuarios.cadastrar.model.CadastrarUserModel;
import com.wzzy.virtualmovies.usuarios.cadastrar.repository.CadastrarUserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Service
public class MoviesService {

    final MovieRepository movieRepository;
    final CadastrarUserRepository userRepository;

    public MoviesService(MovieRepository movieRepository, CadastrarUserRepository userRepository){
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    public List<String> findAllGenres() {
        return movieRepository.findAll()
                .stream()
                .flatMap(movie -> movie.getGenero().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie findById(UUID id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie favoriteMovie(UUID movieId, UUID userId) {
        Movie movie = findById(movieId);
        CadastrarUserModel user = userRepository.findById(userId).orElse(null);
        if (movie != null && user != null) {
            user.getFavoriteMovies().add(movie);
            userRepository.save(user);
        }
        return movie;
    }

    public Movie addMovieToList(UUID movieId, UUID userId) {
        Movie movie = findById(movieId);
        CadastrarUserModel user = userRepository.findById(userId).orElse(null);
        if (movie != null && user != null) {
            user.getMovieList().add(movie);
            userRepository.save(user);
        }
        return movie;
    }

    public String getMovieVideoUrl(UUID id) {
        Movie movie = findById(id);
        if (movie != null) {
            return movie.getVideoUrl();
        }
        return null;
    }

    public List<Movie> findByCategory(String category) {
        return movieRepository.findByCategory(category);
    }
    public List<Movie> findByTitulo(String titulo) {
        return movieRepository.findByTitulo(titulo);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
