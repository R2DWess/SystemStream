package com.wzzy.virtuallibrary.movie.controller;

import com.wzzy.virtuallibrary.movie.Movie;
import com.wzzy.virtuallibrary.movie.service.MoviesService;
import com.wzzy.virtuallibrary.usuarios.cadastrar.model.CadastrarUserModel;
import com.wzzy.virtuallibrary.usuarios.cadastrar.services.CadastrarUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/movies")
public class MoviesController {

    final MoviesService moviesService;
    final CadastrarUserService cadastrarUserService;

    public MoviesController(MoviesService moviesService, CadastrarUserService cadastrarUserService) {
        this.moviesService = moviesService;
        this.cadastrarUserService = cadastrarUserService;
    }

    @PostMapping
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(moviesService.save(movie));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.status(HttpStatus.OK).body(moviesService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(moviesService.findById(id));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Movie>> getMoviesByCategory(@PathVariable String category) {
        return ResponseEntity.status(HttpStatus.OK).body(moviesService.findByCategory(category));
    }

    @PostMapping("/{movieId}/favorite/{userId}")
    public ResponseEntity<Movie> favoriteMovie(@PathVariable UUID movieId, @PathVariable UUID userId) {
        return ResponseEntity.status(HttpStatus.OK).body(moviesService.favoriteMovie(movieId, userId));
    }

    @PostMapping("/{movieId}/addToList/{userId}")
    public ResponseEntity<Movie> addMovieToList(@PathVariable UUID movieId, @PathVariable UUID userId) {
        return ResponseEntity.status(HttpStatus.OK).body(moviesService.addMovieToList(movieId, userId));
    }

    @GetMapping("/{id}/watch")
    public ResponseEntity<String> watchMovie(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(moviesService.getMovieVideoUrl(id));
    }

    @GetMapping("/user/{userId}/list")
    public ResponseEntity<List<Movie>> getMovieList(@PathVariable UUID userId) {
        CadastrarUserModel user = cadastrarUserService.findById(userId).orElse(null);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(user.getMovieList());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/user/{userId}/favorites")
    public ResponseEntity<List<Movie>> getFavoriteMovies(@PathVariable UUID userId) {
        CadastrarUserModel user = cadastrarUserService.findById(userId).orElse(null);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(user.getFavoriteMovies());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Movie> getMovieByTitle(@PathVariable String title) {
        return ResponseEntity.status(HttpStatus.OK).body(moviesService.findByTitulo(title));
    }
}
